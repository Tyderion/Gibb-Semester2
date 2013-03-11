<?php
$s = "@@@"; // Seperator
$FILENAME = "antworten.txt";
$anrede = $_POST["anrede"];
$vorname = $_POST["Vorname"];
$nachname = $_POST["Nachname"];
$email = $_POST["E-Mail"];
$antworten = array();
foreach ($_POST as $key => $value) {
  if (preg_match("/frage.*/", $key)) {
    $antworten[$key] = $value;
  }
}

$savestring = $anrede . $s . $vorname . $s . $nachname . $s . $email;
foreach ($antworten as $key => $value) {
  $savestring .= ($s . $value);
}
$savestring .= PHP_EOL;

file_put_contents($FILENAME, $savestring, FILE_APPEND);

echo <<<EOT
<!doctype html>
<html >
<head>
  <meta name="generator" content=
  "HTML Tidy for Linux/x86 (vers 25 March 2009), see www.w3.org" />
  <meta charset="utf-8" />

  <title>Fragen</title>
  <meta name="author" content="jacob" />
  <meta name="generator" content="Ulli Meybohms HTML EDITOR" />
  <link rel="stylesheet" href="umfrage.css" type="text/css" />
</head>

<body>
EOT;


echo "<span> Vielen Dank ". ( $anrede == 1 ? "Herr" : "Frau" ) . " $nachname für das ausfüllen dieser Umfrage. <br> Ihre Antworten wurden gespeichert. <br> Die Ergebnisse werden in naher Zukunft vorhanden sein.</span>\n";

echo "</body> \n</html>\n";

?>
