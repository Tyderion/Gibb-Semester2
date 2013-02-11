"use strict"
var COOKIE_NAME = 'calc-result'
var LOAD_TIME = new Date()
/* Cookie Firefox (via Firefox Cookies view):
  Name: calc-result
  Content: 2.297396709994
  Host:
  Path: /C:/Users/Archie/Documents/Dropbox/Gibb/Semester%202/133%20-%20Webapplikation%20realiseren/taschenrechner/
  Send For: Any type of connection
  Expires: Samstag, 8. Februar 2014 11:00:27
Cookie Internet Explorer
Location: C:\Users\Archie\AppData\Local\Microsoft\Windows\Temporary Internet Files\Taschrenrechner/
Inhalt:
  calc-result
  9.303535670983768e+136
  ~~local~~/C:/Users/Archie/Documents/Dropbox/Gibb/Semester%202/133%20-%20Webapplikation%20realiseren/taschenrechner/
  1088
  4265285760
  30352565
  2241706972
  30279140
  *
  */
//Cookie functions take from: http://www.w3schools.com/js/js_cookies.asp

function setCookie(cookie_name,value,daysUntilExpire)
{
  var expireDate=new Date();
  expireDate.setDate(expireDate.getDate() + daysUntilExpire);
  var c_value=encodeURIComponent(value) + ((daysUntilExpire===null) ? "" : "; expires="+expireDate.toUTCString());
  document.cookie=cookie_name + "=" + c_value;
}

function getCookie(cookie_name)
{
  var i, key_value, cookies = document.cookie.split(";");
  for (i = 0; i < cookies.length; i++) {
    key_value = cookies[i].split("=");
    if (key_value[0].trim() === cookie_name) return decodeURIComponent(key_value[1])
  }
}

function loadResult()
{
var result=getCookie(COOKIE_NAME);
if (result!=null && result!="")
{
  setValue(result)
}
  //We update the clock and the time-passed display 5 times a second
  setInterval(function() {
    window.document.Rechner.Date.value = new Date().toLocaleString()
    // Subtracking 3600*1000ms = 1 Hour because of GMT offset (I guess....)
    window.document.Rechner.Visited.value = new Date(new Date() - LOAD_TIME-3600*1000).toTimeString().slice(0,8)
  }, 200)
}

function saveResult()
{
  result=getValue()
  if (result!=null && result!="")
  {
    setCookie(COOKIE_NAME,result,365);
  }
}

//End Cookie Functions
//Save and load the cookie onunload respectively onload
window.onbeforeunload = saveResult
window.onload = loadResult

//Firefox: 100% Trigger this event
//Chromium: No backspace/delete (and other special keys I guess)
//IE: Like Chrome or sometimes "No Keypress event ..." (The reason is unkown to me)
window.onkeypress=handleKeyPressEvent

//Firefox: 100% Trigger this event
//Chromium/IE: Backspace/delete (etc) also trigger this event
//Backspace always goes back one page except if there is no history.
window.onkeyup=handleKeyUp

function setValue(value) {
  window.document.Rechner.Display.value = value
}

function getValue() {
  return window.document.Rechner.Display.value
}

function setError(error) {
  setValue(error.message+":"+ getValue())
}

function validate(input) {
  return /^[0-9-+*\/.()]+$/.test(input)
}

function calculateResult() {
  var x = 0
  if (validate(getValue())) {
    try {
    //If there is a syntax error (e.g. 2**4 or 2++2 ...)
    x = eval(getValue())
    setValue(round(x))
  } catch (e) {
      // Tell the user it is a syntax error
      setError(e)
    }
  } else {
    setValue('')
  }
}

function round(num) {
  return Number((num).toFixed(12))
}

function add (chr) {
  setValue(getValue() + chr)
}

function handleKeyPressEvent(e) {
  if (e.charCode >= 40 ) //40 = '('
  {
    add(String.fromCharCode(e.charCode))
  }
  }
  function handleKeyUp(e) {
    //For Firefox, this could be in handleKeyPressEvent
    switch(e.keyCode) {
      case 8: //'backspace'
      setValue(getValue().slice(0,-1))
      break
      //case 110: //dot
     // add('.')
      //break
      case 13: // enter
      calculateResult()
      break
      case 46: // delete
      setValue(getValue().slice(1))
      break
    }
  }

  function degreeToRadian(num) {
    return Math.PI/180 * num
  }

  function specials (func) {
   var x = 0
  try { //If there is a syntax error (e.g. 2**4 or 2++2 ...)
    if (validate(x)) {
      x = eval(getValue())
      if (func === "sqrt") {
        setValue(round(Math.sqrt(x)))
      }
      if (func === "pow") {
        setValue(round(x * x))
      }
      if (func === "ln") {
        setValue(round(Math.log(x)))
      }
      if (func === "sin") {
        setValue(round(Math.sin(degreeToRadian(x))))
      }
      if (func === "cos") {
        setValue(round(Math.cos(degreeToRadian(x))))
      }
      if (func === "tan") {
        setValue(round(Math.tan(degreeToRadian(x))))
      }
      if (func === "2^x") {
        setValue(round(Math.pow(2,x)))
      }
    } else {
      setValue(0)
    }
  } catch (e) {
    // Tell the user it is a syntax error
    setError(e)
  }
}
