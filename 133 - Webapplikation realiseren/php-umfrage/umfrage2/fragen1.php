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
<?php // Variables
$auswahlen =array("ja", "eher <br /> ja", "egal", "eher <br /> nein", "nein");
$fragen = file("fragen.txt");
$anreden = array("Frau", "Mann");
$angaben = array("Anrede", "Vorname", "Nachname", "E-Mail");
?>
  <div>
    <form id="questionaire" name="questionaire" action="auswertung.php"
    method="post">
      <span class="title">Fragebogen Wahlen</span>
      <br />
      <br />
          <?php
          foreach ($angaben as $angabe) {
          echo <<<EOT
            <div>
              <div class="angabe" >
                $angabe
              </div>

            <div class="angabe_input">
EOT;
            if ($angabe == "Anrede")
            {
              echo "<select class='formular' name='anrede' size='1'>";
              $i = 0;
              foreach ($anreden as $anrede) {
                echo <<<EOT
                <option value=$i>
                  $anrede
                </option>
EOT;
              $i++;
              }
              echo "</select>";
            } else {
              echo <<<EOT
          <input class="formular" id='required_$angabe'
            maxlength="100" size="30" name='$angabe' />
EOT;
          } echo "</div></div>";
          } ?>
    <table>
        <tr class="headerrow">
          <td><strong>Fragen</strong></td>
          <?php

          foreach ($auswahlen as $wert) {
            ?>
             <td>
            <?php echo $wert ?>
          </td>
    <?php } ?>
        </tr>
        <?php
        $counter = 0;
        foreach ($fragen as $frage) { ?>
          <tr class=<?php echo  $counter % 2 == 0 ? "evenrow" : "oddrow"; ?>
            >
            <td class="frage">
            <?php echo $frage; ?>
          </td>
          <?php
          for ($i = 1; $i<=5; $i++)
          {
            ?>
            <td class="selection">
              <input type="radio" value=<?php echo "$i";
              if ($i == 3) echo ' checked="checked"';?>
              name= <?php echo "frage_$counter" ?>
               />
            </td>
    <?php } $counter++; ?>
        </tr>
  <?php } ?>
    </table>

  <input type="submit" value = "Weiter zur Auswertung" />
  </form>
    </div>
</body>
</html>
