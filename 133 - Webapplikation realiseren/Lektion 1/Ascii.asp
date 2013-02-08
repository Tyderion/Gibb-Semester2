<HTML>
<HEAD><TITLE>Einfache G&uuml;ltigkeitspr&uuml;fung</TITLE>
<%
Dim TextBereich 
Dim Technik
Sub ZeichenAusgeben(intCode)
Dim NeueZeile
NeueZeile = ""
If ((intCode - 31) Mod 11) = 0 Then
    NeueZeile = Chr(13) & Chr(10)
End If
If intCode <= 32 Then
    TextBereich = "Die folgende Tabelle wurde mit '" & Technik & "'-Schleife erstellt" & Chr(13) & Chr(10) & Chr(13) & Chr(10)
End If
If intCode < 100 Then
  TextBereich = TextBereich & "0" & intCode & " " & Chr(intCode) & "  " & NeueZeile
Else
  TextBereich = TextBereich & intCode & " " & Chr(intCode) & "  " & NeueZeile
End If
End Sub

Sub ASCIICodeErzeugen
Dim intI
Technik = Request.Form ("lstTechnik")
If Technik = "" Then
    TextBereich = "Bitte Technik wählen"
Else
  Select Case Technik
    Case "For ... Next"
      For intI = 32 To 255
        ZeichenAusgeben	(intI)
      Next
    Case "While ... Wend"
      intI = 32
      While intI <= 255
        ZeichenAusgeben (intI)
        intI = intI + 1
      Wend
    Case "Do ... Loop Until"
      intI = 32
      Do
        ZeichenAusgeben (intI)
        intI = intI + 1
      Loop Until intI > 255
    End Select  
  End If
Response.Write TextBereich
End Sub
%>
<BODY>
<H3>ASCII- und ANSI-Zeichencodes</H3><HR>
<FORM Name="ASCIIFormular" METHOD="POST"  ACTION="ascii.asp">   
<fieldset>
<legend><b>Technik</b></legend>
<select name="lstTechnik" size="3">
<option>For ... Next
<option>While ... Wend
<option>Do ... Loop Until
</select>
<input type=submit value=" OK (ASP) ">
</fieldset>
<br>
<fieldset>
<legend><b>Anzeige</b></legend>
<textarea name="txtAnzeige" cols="77" rows="24">
<% Call ASCIICodeErzeugen() %>
</textarea>
</fieldset>
</FORM>
</BODY>
</HTML>