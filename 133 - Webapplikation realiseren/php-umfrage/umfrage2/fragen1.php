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

<body text="#000000" bgcolor="#FFFFFF" link="#FF0000" alink=
"#FF0000" vlink="#FF0000">
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
            <div align="left">
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
                <option value=$i selected="selected">
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
    <table cellspacing="1" cellpadding="1" width="578" border="0">
      <tbody>
        <tr class="headerrow" align="left">
          <td class="norm"><strong>Fragen</strong></td>
          <?php

          foreach ($auswahlen as $wert) {
            ?>
             <td class="norm" align="middle">
            <img height="1" src="empty.gif" width="45" />
            <?php echo $wert ?>
          </td>
    <?php } ?>
        </tr>
        <?php
        $counter = 0;
        foreach ($fragen as $frage) { ?>
          <tr class="oddrow" align="left">
            <td class="questiontable">
            <?php echo $frage; ?>
          </td>
          <?php
          for ($i = 1; $i<=5; $i++)
          {
            ?>
            <td class="questiontable" align="middle">
              <input type="radio" value=<?php echo "$i";
              if ($i == 3) echo ' checked="checked"';?>
              name= <?php echo "frage_$counter" ?>
               />
            </td>
    <?php } $counter++; ?>
        </tr>
  <?php } ?>
        <!--tr>
          <td class="norm" align="left"><br />
          <a href="auswertung1.html">&gt; weiter zu Auswertung
          PartnerWahl</a></td>
        </tr-->
      </tbody>
    </table>

  <input type="submit" value = "Weiter zur Auswertung" />
  </form>
    </div>
</body>
</html>
