<HTML>
<HEAD><TITLE>Einfache G&uuml;ltigkeitspr&uuml;fung</TITLE>
<?php
function ZeichenAusgeben($intCode)
{
global $TextBereich;
global $Technik;
if ($intCode <= 32)
    {
    $TextBereich = "Die folgende Tabelle wurde mit '$Technik'-Schleife erstellt\n";
    }
if ($intCode < 100)
    {
    $TextBereich .= "0" . $intCode . " " . chr($intCode) . "  ";
    }
else
    {
    $TextBereich .= $intCode . " " . chr($intCode) . "  ";
    }
if ((($intCode - 31) % 11) == 0)
    {
    $TextBereich .= "\n";
    }
}

function ASCIICodeErzeugen()
{
global $TextBereich;
global $Technik;
if (empty ($_POST["lstTechnik"]))
  {
  $Technik = "";
  }
else
  {
  $Technik=$_POST["lstTechnik"];
  }
if ($Technik == "")
  {
  $TextBereich = "Bitte Technik w&auml;hlen";
  }
else
  {
  switch ($Technik)
    {
    case "For ... Next":
      for ($intI=32;$intI<=255;$intI++)
        {
        ZeichenAusgeben ($intI);
        }
      break;
    case "While ... Wend":
      $intI = 32;
      while ($intI <= 255)
        {
        ZeichenAusgeben ($intI);
        $intI = $intI + 1;
        }
      break;
    case "Do ... Loop Until":
      $intI = 32;
      do
        {
        ZeichenAusgeben ($intI);
        $intI = $intI + 1;
        }
      while ($intI <= 255);
      break;
    }
  }
}
?>
</HEAD>
<BODY>
<H3>ASCII- und ANSI-Zeichencodes</H3><HR>
<FORM Name="ASCIIFormular" METHOD="POST"  ACTION="ascii.php">
<fieldset>
<legend><b>Technik</b></legend>
<select name="lstTechnik" size="3">
<option>For ... Next
<option>While ... Wend
<option>Do ... Loop Until
</select>
<input type=submit value=" OK (PHP) ">
</fieldset>
<br>
<fieldset>
<legend><b>Anzeige</b></legend>
<textarea name="txtAnzeige" cols="77" rows="24">
<?php
$TextBereich = "";
ASCIICodeErzeugen();
echo $TextBereich;
?>
</textarea>
</fieldset>
</FORM>
</BODY>
</HTML>