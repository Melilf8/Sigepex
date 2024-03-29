jQuery(document).ready(function()
    { 
        //jQuery("#myTable").tablesorter();
		jQuery("#btnBuscar").click(function() {
			Buscar();
		});


    } 
); 




	jQuery(function() {
		var dates = jQuery( "#from, #to" ).datepicker({
			defaultDate: "+1w",
			changeMonth: true,
			changeYear:true,
			gotoCurrent:true,
			autoSize: true,
			currentText: "Hoy",
			monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
			dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
		    numberOfMonths: 1,
			onSelect: function( selectedDate ) {
				var option = this.id == "from" ? "minDate" : "maxDate",
					instance = jQuery( this ).data( "datepicker" ),
					date = jQuery.datepicker.parseDate(
						instance.settings.dateFormat ||
						jQuery.datepicker._defaults.dateFormat,
						selectedDate, instance.settings );
				dates.not( this ).datepicker( "option", option, date );
			}
		});
	});


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
	output+="<table id=\"myTable\" class=\"tablesorter\"><thead> <tr> <th>Numero De Orden </th> <th>Tipo Documental</th><th>Folios</th> <th>Funcionario</th> <th>Dependencia</th><th>Nombre </th><th>Id Estudiante</th> </tr> </thead> <tbody> ";
	for (var i = 0;i<20 ;i++ )
	{
		output+="<tr><td>"+ i +"</td> <td>TPD"+i+"</td> <td>Folios"+i+"</td> <td>"+ Usuario(i) +"</td> <td>"+Dependecia(i)+"</td> <td>Nombre"+i+"</td> <td>"+UsuarioId(i)+"</td></tr>";
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


function Usuario(i)
{
    if(jQuery("#txtUsuario").val().length > 0)
    {
        return jQuery("#txtUsuario").val();
    }else{
        return "Usuario"+i;
    }
}

function UsuarioId(i)
{
    if(jQuery("#idest").val().length > 0)
    {
        return jQuery("#idest").val();
    }else{
        return "UsuarioId"+i;
    }
}
	 
