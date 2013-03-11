<?php
$s = "@@@"; // Seperator
$FILENAME = "antworten.txt";
foreach ($_POST as $key => $value) {
  echo $key . ": " . $value . "<br />";
}
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
print_r($antworten);
echo "<br />";

$savestring = $anrede . $s . $vorname . $s . $email;
foreach ($antworten as $key => $value) {
  $savestring .= ($s . $value);
}
$savestring .= PHP_EOL;

file_put_contents($FILENAME, $savestring, FILE_APPEND);

echo "Vielen Dank ". ( $anrede == 1 ? "Herr" : "Frau" ) . " $nachname für das ausfüllen dieser Umfrage. <br /> Ihre Antworten wurden gespeichert. <br /> Die Ergebnisse werden in naher Zukunft vorhanden sein.";

?>
