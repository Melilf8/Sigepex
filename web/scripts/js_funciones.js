
function salir(){
    window.location = "frm_login.jspx";
}
function recargar(){
    location.reload();
}

function mostrar() {
    var elemento = document.getElementById("listaSeriesDoc");
    elemento.className = "visible";

    var enlacemostrar = document.getElementById("enlace_mostrar");
    enlacemostrar.className = "oculto";
    var enlaceocultar = document.getElementById("enlace_ocultar");
    enlaceocultar.className = "visible";


 }
 function ocultar() {
    var elemento = document.getElementById("listaSeriesDoc");
    elemento.className = "oculto";

    var enlacemostrar = document.getElementById("enlace_mostrar");
    enlacemostrar.className = "visible";
    var enlaceocultar = document.getElementById("enlace_ocultar");
    enlaceocultar.className = "oculto";


 }

function validaEnvio_frm_registrar_usuario(formulario)
{
    //formulario.txt_cedula.style.background="white";
    //formulario.txt_nombre.style.background="white";
    //formulario.txt_apellido1.style.background="white";
    //formulario.txt_apellido2.style.background="white";
    //formulario.txt_email.style.background="white";
    //formulario.txt_contrasena.style.background="white";
    //formulario.cmb_rol.itemValue = 0;//.background="white";
    //formulario.cmb_dependencia.itemValue = 0;//.style.background="white";
    //formulario.cmb_estado.itemValue = 0;//.style.background="white";
    
    var correcto = false;

    if(formulario.txt_in_identificacion.value == "" || (formulario.txt_in_identificacion.value<100000000 || formulario.txt_in_identificacion.value>=1000000000)
        || formulario.txt_in_nombre.value == "" || formulario.txt_in_apellido1.value == "" || formulario.txt_in_apellido2.value == ""
        || (formulario.txt_contrasena.value == "")){

        if (formulario.txt_in_identificacion.value == "" || (formulario.txt_in_identificacion.value<100000000 || formulario.txt_in_identificacion.value>=1000000000)) {
            formulario.txt_in_identificacion.style.background="#FF9999";
            window.alert("Por favor digite la Cédula en formato: 109990999");
            formulario.txt_in_identificacion.focus( );
        }
        else if (formulario.txt_in_nombre.value == "") {
            formulario.txt_in_nombre.style.background="#FF9999";
            window.alert("Por favor digite el Nombre!");
            formulario.txt_in_nombre.focus( );
        }
        else if (formulario.txt_in_apellido1.value == "") {
            formulario.txt_in_apellido1.style.background="#FF9999";
            window.alert("Por favor digite el Apellido1!");
            formulario.txt_in_apellido1.focus( );
        }
        else if (formulario.txt_in_apellido2.value == "") {
            formulario.txt_in_apellido2.style.background="#FF9999";
            window.alert("Por favor digite el Apellido2!");
            formulario.txt_in_apellido2.focus( );
        }
        else if (formulario.txt_in_contrasena.value == "") {
            formulario.txt_in_contrasena.style.background="#FF9999";
            window.alert("Por favor digite la contraseña!");
            formulario.txt_in_contrasena.focus( );
        }
    }
    else{ correcto = true; }

    return correcto;
}

function validaNumeros(e)
{
    var key = '';
    var strCheck = '1234567890';

       var whichCode = (window.Event) ? e.which : e.keyCode;

       if (whichCode == 13)//<== Enter
         return true;

         if (whichCode == 8)//<== Backspace
         return true;

       if (whichCode ===0)//<== TAB
         return true;
       key = String.fromCharCode(whichCode);//<== Obtiene la letra a partir del código

       if (strCheck.indexOf(key) == -1)//<== No es una tecla válida
          return false;
       else
          return true;
    return false;
}

function validaLetras(e) {
var key = '';
var strCheck = 'abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ';

   var whichCode = (window.Event) ? e.which : e.keyCode;

   if (whichCode == 13)//<== Enter
     return true;

   if (whichCode == 8)//<== Backspace
     return true;

   if (whichCode == 32)//<== Espacio
     return true;

   if (whichCode ===0)//<== TAB
     return true;
   key = String.fromCharCode(whichCode);//<== Obtiene la letra a partir del código

   if (strCheck.indexOf(key) == -1)//<== No es una tecla válida
      return false;
   else
      return true;
return false;
}

function fecha()
{
    var dateTime = new Date();
    dateTime.getDate();
    window.alert(dateTime.toString());
    return true;
}

function fechaDeEmision()
{
    var dateTime = new Date();
    dateTime.getDate();
    return (dateTime.toString());
}

/*--  EXPRESIONES REGULARES  --*/

function validaNumeroRegular(formulario)
{
    var msg ="";
    /* Formato = nn+nn+nn+nn */
    ExpresioRegular=/\d{2}\+{1}\d{2}\+{1}\d{2}\+{1}\d{2}$/;

    if(formulario.txtTelefono.value != "" && ExpresioRegular.test(formulario.txtTelefono.value))
        msg = "Formato Telefonico Correcto";
    else
        if(formulario.txtTelefono.value != "")
            msg = "Formato Telefonico Incorrecto";

    if(formulario.txtCelular.value != "" && ExpresioRegular.test(formulario.txtCelular.value))
        msg += "\nFormato Celular Correcto";
    else
        if(formulario.txtCelular.value != "")
            msg += "\nFormato Celular Incorrecto";

    if(msg != "")
        window.alert(msg);
}

function validaEmail(campo) {
    var RegExPattern = /[\w-\.]{3,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}$/;
    var errorMessage = 'El formato del correo es incorrecto.';
    if ((campo.value.match(RegExPattern)) && (campo.value!='')) {
        //alert('Email Correct0');
    } else {
        alert(errorMessage);
        campo.focus();
    }
}

function validaContrasenaSegura(campo) {
    //(Entre 8 y 10 caracteres, por lo menos un digito y un alfanumérico, y no puede contener caracteres espaciales)
    var RegExPattern = /(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{8,10})$/;
    var errorMessage = 'Contraseña debe contener entre 8 y 10 caracteres, por lo menos un digito y un alfanumérico, y no puede contener caracteres espaciales';
    if ((campo.value.match(RegExPattern)) && (campo.value!='')) {
        //alert('Contraseña Correcta');
    } else {
        alert(errorMessage);
        campo.focus();
    }
}

function validaFecha(campo) {
    //(Por ejemplo 01/01/2007)
    var RegExPattern = /^\d{1,2}\/\d{1,2}\/\d{2,4}$/;
    var errorMessage = 'Formato de fecha debe ser Por ejemplo 01/01/2007';
    if ((campo.value.match(RegExPattern)) && (campo.value!='')) {
        //alert('Fecha Valida');
    } else {
        alert(errorMessage);
        campo.focus();
    }
}

function validaHora(campo) {
    //(Por ejemplo 10:45:23)
    var RegExPattern = /^(0[1-9]|1\d|2[0-3]):([0-5]\d):([0-5]\d)$/;
    var errorMessage = 'Formato de hora incorrecto..';
    if ((campo.value.match(RegExPattern)) && (campo.value!='')) {
        //alert('Formato Correcto');
    } else {
        alert(errorMessage);
        campo.focus();
    }
}

function validaTelefono(campo) {
    var RegExPattern = /^[0-9]{2,3}-? ?[0-9]{6,7}$/;
    var errorMessage = 'Formato incorrecto..';
    if ((campo.value.match(RegExPattern)) && (campo.value!='')) {
        //alert('Formato Correcto');
    } else {
        alert(errorMessage);
        campo.focus();
    }
}

function MM_openBrWindow(theURL,winName,features)
{
  window.open(theURL,winName,features);
}

/*
-------------------------------------------------------------------------------------------------------------------
La tabla siguiente contiene los caracteres especiales de las expresiones regulares.
-----------------------------------------------------------------------------------
Carácter 	Texto buscado
--------    -------------
^			Principio de entrada o línea.
$			Fin de entrada o línea.
*			El carácter anterior 0 o más veces.
+			El carácter anterior 1 o más veces.
?			El carácter anterior una vez como máximo (es decir, indica que el carácter anterior es opcional).
.			Cualquier carácter individual, salvo el de salto de línea.
x|y			x o y.
{n}			Exactamente n apariciones del carácter anterior.
{n,m}		Como mínimo n y como máximo m apariciones del carácter anterior.
[abc]		Cualquiera de los caracteres entre corchetes. Especifique un rango de caracteres con un guión (por ejemplo, [a-f] es equivalente a [abcdef]).
[^abc]		Cualquier carácter que no esté entre corchetes. Especifique un rango de caracteres con un guión (por ejemplo, [^a-f] es equivalente a [^abcdef]).
\b			Límite de palabra (como un espacio o un retorno de carro).
\B			Cualquiera que no sea un límite de palabra.
\d			Cualquier carácter de dígito. Equivalente a [0-9].
\D			Cualquier carácter que no sea de dígito. Equivalente a [^0-9].
\f			Salto de página.
\n			Salto de línea.
\r			Retorno de carro.
\s			Cualquier carácter individual de espacio en blanco (espacios, tabulaciones, saltos de página o saltos de línea).
\S			Cualquier carácter individual que no sea un espacio en blanco.
\t			Tabulación.
\w			Cualquier carácter alfanumérico, incluido el de subrayado. Equivalente a [A-Za-z0-9_].
\W			Cualquier carácter que no sea alfanumérico. Equivalente a [^A-Za-z0-9_].
-------------------------------------------------------------------------------------------------------------------
*/


