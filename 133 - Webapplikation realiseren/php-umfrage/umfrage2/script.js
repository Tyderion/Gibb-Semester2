 function checkForm()
 {
    var errText = '';
    if ( document.regform.required_nl_Firstname.value == '' ) errText += '- Vorname fehlt\n';
    if ( document.regform.required_nl_Lastname.value == '' ) errText += '- Nachname fehlt\n';
    if ( document.regform.required_nl_Email.value == '' ) errText += '- E-Mail fehlt\n';
    if ( errText != '' )
    {
                alert( errText );
        return false;
    }
    else
        {
        return true;
        }
 }
