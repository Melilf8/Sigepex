/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function cargarMenu_DOM(){
        var losforms = 'frm_mantenimiento_usuarios,frm_aprobar_prestamo,frm_aprobar_remision,frm_consultar_prestamo,frm_consultar_remision,frm_llenar_remision,frm_parametros,frm_solicitar_prestamo,frm_reporte_prestamo,frm_reporte_remision,frm_admin_roles,frm_admin_ius_por_rol,frm_admin_serie_documental,frm_admin_mensajes_ayuda,frm_inicio';
		//var losforms = 'frm_mantenimiento_usuarios,frm_consultar_prestamo,frm_consultar_remision,frm_llenar_remision,frm_solicitar_prestamo,frm_inicio';

		var posicion;

		var ul = document.createElement('ul');
		ul.className = 'menu';

		// ----------------------   Expedientes  ----------------------------------------------
		var li = document.createElement('li');//												<li>
		var a = crearLink('#', 'Expedientes');//												<a href="#" class="parent"><span>Expedientes</span></a>
		a.className = 'parent';
		li.appendChild(a);
		var div_sub1 = document.createElement('div');//											<div>
		var ul_sub1 = document.createElement('ul');//											<ul>
		var li_sub1;
		// -- Consultar Prestamo Expediente
		posicion = losforms.indexOf('frm_consultar_prestamo');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_consultar_prestamo.jspx', 'Consultar Prestamo Expediente');//	<a href="frm_consultar_prestamo.jspx"><span>Consultar Prestamo Expediente</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		// -- Solicitar Prestamo Expediente
		posicion = losforms.indexOf('frm_solicitar_prestamo');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_solicitar_prestamo.jspx', 'Solicitar Prestamo Expediente');//	<a href="frm_solicitar_prestamo.jspx"><span>Solicitar Prestamo Expediente</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		// -- Aprobar Prestamo Expediente
		posicion = losforms.indexOf('frm_aprobar_prestamo');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_aprobar_prestamo.jspx', 'Aprobar Prestamo Expediente');//		<a href="frm_aprobar_prestamo.jspx"><span>Aprobar Prestamo Expediente</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		//-- Agregar elementos del nivel mas bajo al mas alto
		div_sub1.appendChild(ul_sub1);//														</ul>
		li.appendChild(div_sub1);//																</div>
		ul.appendChild(li);//																	</li>

		// ---------------------- Lista Remision  --------------------------------------------
		li = document.createElement('li');
		a = crearLink('#', 'Lista Remision');
		a.className = 'parent';
		li.appendChild(a);
		div_sub1 = document.createElement('div');//												<div>
		ul_sub1 = document.createElement('ul');//												<ul>
		// -- Consultar Lista Remision
		posicion = losforms.indexOf('frm_consultar_remision');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_consultar_remision.jspx', 'Consultar Lista Remision');//			<a href="frm_consultar_remision.jspx"><span>Consultar Lista Remision</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		// -- Llenar Lista Remision
		posicion = losforms.indexOf('frm_llenar_remision');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_llenar_remision.jspx', 'Llenar Lista Remision');//				<a href="frm_llenar_remision.jspx"><span>Llenar Lista Remision</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		// -- Aprobar Lista Remision
		posicion = losforms.indexOf('frm_aprobar_remision');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_aprobar_remision.jspx', 'Aprobar Lista Remision');//				<a href="frm_aprobar_prestamo.jspx"><span>Aprobar Prestamo Expediente</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		//-- Agregar elementos del nivel mas bajo al mas alto
		div_sub1.appendChild(ul_sub1);//														</ul>
		li.appendChild(div_sub1);//																</div>
		ul.appendChild(li);//																	</li>

		// ---------------------- Funcionarios -----------------------------------------------
		li = document.createElement('li');
		a = crearLink('#', 'Funcionarios');
		a.className = 'parent';
		li.appendChild(a);
		div_sub1 = document.createElement('div');//												<div>
		ul_sub1 = document.createElement('ul');//												<ul>
		// -- Consultar Lista Remision
		posicion = losforms.indexOf('frm_mantenimiento_usuarios');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_mantenimiento_usuarios.jspx', 'Administrar Usuarios');//			<a href="frm_mantenimiento_usuarios.jspx"><span>Administrar Usuarios</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		//-- Agregar elementos del nivel mas bajo al mas alto
		div_sub1.appendChild(ul_sub1);//														</ul>
		li.appendChild(div_sub1);//																</div>
		ul.appendChild(li);//

		// ----------------------   Reportes   -----------------------------------------------
		li = document.createElement('li');
		a = crearLink('#', 'Reportes');
		a.className = 'parent';
		li.appendChild(a);
		div_sub1 = document.createElement('div');//												<div>
		ul_sub1 = document.createElement('ul');//												<ul>
		// -- Reportes Prestamo Expedientes
		posicion = losforms.indexOf('frm_reporte_prestamo');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_reporte_prestamo.jspx', 'Reportes Prestamo Expedientes');//		<a href="frm_reporte_prestamo.jspx"><span>Reportes Prestamo Expedientes</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		// -- Reportes Lista de Remision
		posicion = losforms.indexOf('frm_reporte_remision');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_reporte_remision.jspx', 'Reportes Lista de Remision');//			<a href="frm_reporte_remision.jspx"><span>Reportes Lista de Remision</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		//-- Agregar elementos del nivel mas bajo al mas alto
		div_sub1.appendChild(ul_sub1);//														</ul>
		li.appendChild(div_sub1);//																</div>
		ul.appendChild(li);//																	</li>

		// ---------------------- Administracion  --------------------------------------------
		li = document.createElement('li');
		li.className = 'last';
		a = crearLink('#', 'Administracion');
		a.className = 'parent';
		li.appendChild(a);
		div_sub1 = document.createElement('div');//												<div>
		ul_sub1 = document.createElement('ul');//												<ul>
		// -- Parametros SIGEPEX
		posicion = losforms.indexOf('frm_parametros');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_parametros.jspx', 'Parametros SIGEPEX');//						<a href="frm_parametros.jspx"><span>Parametros SIGEPEX</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		// -- Roles de Usuario
		posicion = losforms.indexOf('frm_admin_roles');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_admin_roles.jspx', 'Roles de Usuario');//						<a href="frm_admin_roles.jspx"><span>Roles de Usuario</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		// -- Pantallas por Rol
		posicion = losforms.indexOf('frm_admin_ius_por_rol');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_admin_ius_por_rol.jspx', 'Pantallas por Rol');//					<a href="frm_admin_ius_por_rol.jspx"><span>Pantallas por Rol</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		// -- Series Documentales
		posicion = losforms.indexOf('frm_admin_serie_documental');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_admin_serie_documental.jspx', 'Series Documentales');//			<a href="frm_admin_serie_documental.jspx"><span>Series Documentales</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}
		// -- Mensajes de Ayuda
		posicion = losforms.indexOf('frm_admin_mensajes_ayuda');
		if(posicion != -1)
		{
			li_sub1 = document.createElement('li');//											<li>
			a = crearLink('frm_admin_mensajes_ayuda.jspx', 'Mensajes de Ayuda');//				<a href="frm_admin_mensajes_ayuda.jspx"><span>Mensajes de Ayuda</span></a>
			li_sub1.appendChild(a);
			ul_sub1.appendChild(li_sub1);
		}

		//-- Agregar elementos del nivel mas bajo al mas alto
		div_sub1.appendChild(ul_sub1);//														</ul>
		li.appendChild(div_sub1);//																</div>
		ul.appendChild(li);//																	</li>

		// agregar a la pagina
		var div = document.getElementById('menu');
		div.appendChild(ul);

    }

    function crearLink(url,text){
        var link = document.createElement('a');
        link.setAttribute('href', url);
        var span = document.createElement('span');
        span.appendChild(document.createTextNode(text));
        link.appendChild(span);
        return link;
    }

    function cargarMenu_innerHTML()
    {        
		//var losforms = 'frm_mantenimiento_usuarios,frm_aprobar_prestamo,frm_aprobar_remision,frm_consultar_prestamo,frm_consultar_remision,frm_llenar_remision,frm_parametros,frm_solicitar_prestamo,frm_reporte_prestamo,frm_reporte_remision,frm_admin_roles,frm_admin_ius_por_rol,frm_admin_serie_documental,frm_admin_mensajes_ayuda,frm_inicio';
		//var losforms = 'frm_mantenimiento_usuarios,frm_consultar_prestamo,frm_consultar_remision,frm_llenar_remision,frm_solicitar_prestamo,frm_inicio';
        var navegador = '';
        if(window.ActiveXObject)
            navegador = 'IE';

        var losforms;
        var cadena = document.getElementById("f1");
        
        losforms = cadena.textContent;

        if(losforms == '' || losforms == 'undefined')
            losforms = cadena.innerHTML;

        /*
        if(losforms == '' || losforms != 'undefined')
            losforms = cadena.innerText;

        if(losforms == '' || losforms != 'undefined')
            losforms = cadena.outerText;
        */

        var vst_codigoHtml = '';
		//vst_codigoHtml = '<table style=\"margin-top:0px;\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"1195\">';//<= ojo la tabla no se agrega porque el codigo se agrega dentro de ella
		vst_codigoHtml += '                    <tr>';
		vst_codigoHtml += '              	      <td  align=\"left\">';
		vst_codigoHtml += '              	      	<img src=\"imagenes/logoSIA.jpg\" height=\"100\" width=\"100\"/>';
		vst_codigoHtml += '              	      </td>';
		vst_codigoHtml += '                        <td>';
		vst_codigoHtml += '                            <div id=\"menu\" align=\"center\">';
		vst_codigoHtml += '                                <ul class=\"menu\">';
		vst_codigoHtml += '                                    <li><a href=\"#\" class=\"parent\"><span>Expedientes</span></a>';
        if(losforms.indexOf('frm_consultar_prestamo') != -1 || losforms.indexOf('frm_solicitar_prestamo') != -1 || losforms.indexOf('frm_aprobar_prestamo') != -1)
        {
            vst_codigoHtml += '                                        <div><ul>';            
            if(losforms.indexOf('frm_consultar_prestamo') != -1)
                vst_codigoHtml += '                                               <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_consultar_prestamo.jspx\')\"><span>Consultar Prestamo Expediente</span></a></li>'
            if(losforms.indexOf('frm_solicitar_prestamo') != -1)
                vst_codigoHtml += '                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_solicitar_prestamo.jspx\')\"><span>Solicitar Prestamo Expediente</span></a></li>';
            if(losforms.indexOf('frm_aprobar_prestamo') != -1)
                vst_codigoHtml += '                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_aprobar_prestamo.jspx\')\"><span>Aprobar Prestamo Expediente</span></a></li>';
            vst_codigoHtml += '                                        </ul></div>';
        }
		vst_codigoHtml += '                                    </li>';
		vst_codigoHtml += '                                    <li><a href=\"#\" class=\"parent\"><span>Lista Remision</span></a>';
        if(losforms.indexOf('frm_consultar_remision') != -1 || losforms.indexOf('frm_llenar_remision') != -1 || losforms.indexOf('frm_aprobar_remision') != -1)
        {
            vst_codigoHtml += '                                        <div><ul>';
            if(losforms.indexOf('frm_consultar_remision') != -1)
                vst_codigoHtml += '                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_consultar_remision.jspx\')\"><span>Consultar Lista Remision</span></a></li>';
            if(losforms.indexOf('frm_llenar_remision') != -1)
                vst_codigoHtml += '                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_llenar_remision.jspx\')\"><span>Llenar Lista Remision</span></a></li>';
            if(losforms.indexOf('frm_aprobar_remision') != -1)
                vst_codigoHtml += '                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_aprobar_remision.jspx\')\"><span>Aprobar Lista Remision</span></a></li>';
            vst_codigoHtml += '                                        </ul></div>';
        }
        vst_codigoHtml += '                                    </li>';
        vst_codigoHtml += '                                    <li><a href="#" class="parent"><span>Funcionarios</span></a>';
        if(losforms.indexOf('frm_mantenimiento_usuarios') != -1)
        {
            vst_codigoHtml += '                                        <div><ul>';
            vst_codigoHtml += '                                                <li><a href="#\" onclick=\"cambiarPagina(\'frm_mantenimiento_usuarios.jspx\')"><span>Administrar Usuarios</span></a></li>';
            vst_codigoHtml += '                                        </ul></div>';
        }
		vst_codigoHtml += '                                    </li>';
		vst_codigoHtml += '                                    <li><a href=\"#\" class=\"parent\"><span>Reportes</span></a>';
        if(losforms.indexOf('frm_reporte_prestamo') != -1 || losforms.indexOf('frm_reporte_remision') != -1)
        {
            vst_codigoHtml += '                                        <div><ul>';
            if(losforms.indexOf('frm_reporte_prestamo') != -1)
                vst_codigoHtml += '                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_reporte_prestamo.jspx\')\"><span>Reportes Prestamo Expedientes</span></a></li>';
            if(losforms.indexOf('frm_reporte_remision') != -1)
                vst_codigoHtml += '                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_reporte_remision.jspx\')\"><span>Reportes Lista de Remision</span></a></li>';
            vst_codigoHtml += '                                        </ul></div>';
        }
		vst_codigoHtml += '                                    </li>';
		vst_codigoHtml += '                                    <li class=\"last\"><a href=\"#\" class=\"parent\"><span>Administracion</span></a>';
        if(losforms.indexOf('frm_parametros') != -1 || losforms.indexOf('frm_admin_roles') != -1 || losforms.indexOf('frm_admin_roles') != -1 || losforms.indexOf('frm_admin_ius_por_rol') != -1 || losforms.indexOf('frm_admin_serie_documental') != -1 || losforms.indexOf('frm_admin_mensajes_ayuda') != -1)
        {
            vst_codigoHtml += '                                        <div><ul>';
            if(losforms.indexOf('frm_parametros') != -1)
                vst_codigoHtml += '                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_parametros.jspx\')\"><span>Parametros SIGEPEX</span></a></li>';
            if(losforms.indexOf('frm_admin_roles') != -1)
                vst_codigoHtml += '                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_admin_roles.jspx\')\"><span>Roles de Usuario</span></a></li>';
            if(losforms.indexOf('frm_admin_ius_por_rol') != -1)
                vst_codigoHtml += '                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_admin_ius_por_rol.jspx\')\"><span>Pantallas por Rol</span></a></li>';
            if(losforms.indexOf('frm_admin_serie_documental') != -1)
                vst_codigoHtml += '                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_admin_serie_documental.jspx\')\"><span>Series Documentales</span></a></li>';
            if(losforms.indexOf('frm_admin_mensajes_ayuda') != -1)
                vst_codigoHtml += '                                                <li><a href=\"#\" onclick=\"cambiarPagina(\'frm_admin_mensajes_ayuda.jspx\')\"><span>Mensajes de Ayuda</span></a></li>';
            vst_codigoHtml += '                                        </ul></div>';
        }
		vst_codigoHtml += '                                    </li>';
		vst_codigoHtml += '                                </ul>';
		vst_codigoHtml += '                            </div>';
		vst_codigoHtml += '                        </td>';
		vst_codigoHtml += '                    </tr>';
		//vst_codigoHtml += '                </table>';//<= ojo la tabla no se agrega porque el codigo se agrega dentro de ella

        if(navegador == 'IE')
        {
            var vst_codigoHtmlTmp = '<table style=\"margin-top:0px;\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"1195\">';
            vst_codigoHtmlTmp += vst_codigoHtml;
            vst_codigoHtmlTmp += '</table>'
            vst_codigoHtml = vst_codigoHtmlTmp;
            document.getElementById('d1').innerHTML = vst_codigoHtml;
        }
        else
            document.getElementById('tabla').innerHTML = vst_codigoHtml;

        cambiarPagina('frm_inicio.jspx');
    }
   
    function cambiarPagina(urlDestino){
        var url = "/Sigepex/"+urlDestino;
        document.all.ifrmContainer.src = url;
	}

	function cargarPagina(urlDestino){
		$("#div_container").load(urlDestino);
	}

    function loadPage(urlDestino){
        alert("/Sigepex/");
		$("#ifrmContainer").load("/Sigepex/"+urlDestino);
	}

    function redirect(urlDestino){
        window.location = urlDestino;
    }

    function ConstructorXMLHttpRequest()
    {
        if(window.XMLHttpRequest) /*Vemos si el objeto window (la base de
        la ventana del navegador) posee el método
        XMLHttpRequest(Navegadores como Mozilla y Safari). */
        {
            return new XMLHttpRequest(); //Si lo tiene, crearemos el objeto con este método.
        }
        else if(window.ActiveXObject) /*Sino tenía el método anterior,
        debería ser el Internet Exp. un navegador que emplea objetos
        ActiveX, lo mismo, miramos si tiene el método de creación. */
        {
            /*Hay diferentes versiones del objeto, creamos un array, que
            contiene los diferentes tipos desde la
            versión mas reciente, hasta la mas antigua */
            var versionesObj = new Array(
            'Msxml2.XMLHTTP.5.0',
            'Msxml2.XMLHTTP.4.0',
            'Msxml2.XMLHTTP.3.0',
            'Msxml2.XMLHTTP',
            'Microsoft.XMLHTTP');
            for (var i = 0; i < versionesObj.length; i++)
            {
                try
                {
                /*Intentamos devolver el objeto intentando crear las diferentes
                versiones se puede intentar crear uno que no existe y se
                producirá un error. */
                return new ActiveXObject(versionesObj[i]);
                }
                catch (errorControlado) //Capturamos el error, ya que podría crearse otro objeto.
                {
                }
            }
        }
        /* Si el navegador llego aquí es porque no posee manera alguna de
        crear el objeto, emitimos un mensaje de error. */
        throw new Error("No se pudo crear el objeto XMLHttpRequest");
    }

    /*
        For example if the current URL is "...?opendocument&id=testid"
        then calling getURLParam("id") will return "testid".
    */
    function getURLParam(strParamName){
        var strReturn = "";
        var strHref = window.location.href;
        if ( strHref.indexOf("?") > -1 ){
            var strQueryString = strHref.substr(strHref.indexOf("?")).toLowerCase();
            var aQueryString = strQueryString.split("&");
            for (var iParam = 0; iParam < aQueryString.length; iParam++ ){
                if(aQueryString[iParam].indexOf(strParamName.toLowerCase() + "=") > -1 ){
                    var aParam = aQueryString[iParam].split("=");
                    strReturn = aParam[1];
                    break;
                }
            }
        }
        //return unescape(strReturn);
        document.getElementById('txt_in_identificacion').innerHTML = strReturn;
    }

    function queryString(parameter) {
      var loc = location.search.substring(1, location.search.length);
      var param_value = false;

      var params = loc.split('&');
      for (i=0; i<params.length;i++) {
          param_name = params[i].substring(0,params[i].indexOf('='));
          if (param_name == parameter) {
              param_value = params[i].substring(params[i].indexOf('=')+1)
          }
      }
      if (param_value) {
          return param_value;
      }
      else {
          return false; //Here determine return if no parameter is found
      }
    }