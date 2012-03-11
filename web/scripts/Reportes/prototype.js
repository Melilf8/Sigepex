jQuery(document).ready(function()
    {
        var dates = jQuery( "#from, #to" ).datepicker({
			defaultDate: "+1w",
			changeMonth: true,
			changeYear:true,
			gotoCurrent:true,
			autoSize: true,
			currentText: "Hoy",
            dateFormat: 'yy-mm-dd',
			monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
			dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
		    numberOfMonths: 1,
			onSelect: function( selectedDate ) {
				var option = this.id == "to" ? "maxDate" : "minDate",
					instance = jQuery( this ).data( "datepicker" ),
					date = jQuery.datepicker.parseDate(
						instance.settings.dateFormat ||
						jQuery.datepicker._defaults.dateFormat,
						selectedDate, instance.settings );
				dates.not( this ).datepicker( "option", option, date );
			}
		});


    }
);



function Buscar()
{
	var fecha_inicio = jQuery("#from").val();
	var fecha_final = jQuery("#to").val();
	var unidad_academica = jQuery("#unca option:selected").val();
	var funcionario = jQuery("#txtUsuario").val();
	if(fecha_inicio != "" ||fecha_final != "" || unidad_academica != 0 ||funcionario != ""  )
	{
	  jQuery.ajax({
		url: "script.php",
		type: "GET",
		data: {fInicio : fecha_inicio,
			   fFinal : fecha_final,
			   uAcade: unidad_academica,
			   func: funcionario
			  },
		dataType: "JSON",
		success: function(data){
				MostrarData(data);
		},
		error: function(data){
			//alert("error");
			CrearTabla();
		}
	  });
	}else{
		alert('Se necesita al menos un criterio para la busqueda');
			jQuery("#tableSpace").empty();
	}
}

function CrearTabla()
{
	var output ="";
	jQuery("#tableSpace").empty();
	output+="<table id=\"myTable\" class=\"tablesorter\"><thead> <tr> <th>Numero De Boleta</th> <th>Dependencia</th> <th>Fecha de Prestamo</th> <th>Usuario</th></tr> </thead> <tbody> ";
	for (var i = 0;i<20 ;i++ )
	{
		output+="<tr><td>"+ i +"</td> <td>"+Dependecia(i)+"</td> <td>"+Fecha()+"</td> <td>"+Usuario(i)+"</td></tr>";
	}
	output+="</tbody></table>";
	jQuery("#tableSpace").append(output);
	jQuery("#myTable").tablesorter();

}

function Dependecia(i)
{
    if(jQuery("#unca option:selected").val() != 0)
    {
        return jQuery("#unca option:selected").text();
    }else{
        return "Dependencia"+i
    }
}

function Fecha()
{
    if(jQuery("#from").val().length > 0)
    {
        return jQuery("#from").val();
    }else{
        return "01/01/2010";
    }
}

function Usuario(i)
{
    if(jQuery("#txtUsuario").val().length > 0)
    {
        return jQuery("#txtUsuario").val();
    }else{
        return "Usuario"+i;
    }
}
function CrearReporte()
{
    var fechaini = jQuery('.inputFrom').val();
    var fechafin = jQuery('.inputTo').val();
    var funcionario = jQuery('.inputFunc').val();
    var dependencia =  jQuery('.inputCombo').val();
    var href = "/Sigepex/ReportExpediente?fi=" + fechaini + "&ff=" + fechafin + "&de="+ dependencia +"&fu=" + funcionario;
    window.open(href,'_newtab');
}

function CrearReporteRemision()
{
    var fechaini = jQuery('.inputFrom').val();
    var fechafin = jQuery('.inputTo').val();
    var idEstudiante = jQuery('#txtIdEstudiante').val();
    var funcionario = jQuery('#txtFuncionario').val();
    var dependencia =  jQuery('.inputCombo').val();
    var href = "/Sigepex/ReporteRemision?fi=" + fechaini + "&ff=" + fechafin + "&de="+ dependencia +"&fu=" + funcionario+"&id="+idEstudiante;
    window.open(href,'_newtab');

}


    