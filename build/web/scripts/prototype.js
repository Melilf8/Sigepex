$(document).ready(function() 
    { 
        //$("#myTable").tablesorter(); 
		$("#btnBuscar").click(function() {
			Buscar();
		});
 $(document).ready(function(){
                   $("#enlaceocultar").click(function(evento){
                       $("#listaSeriesDoc").css("display", "none");
                       $("#enlacemostrar").css("display","block");
                       $("#enlaceocultar").css("display", "none");
                   });

                   $("#enlacemostrar").click(function(evento){
                       $("#listaSeriesDoc").css("display","block");
                       $("#enlacemostrar").css("display","block");
                       $("#enlaceocultar").css("display", "none");
                   });


    } 
); 




	$(function() {
		var dates = $( "#from, #to" ).datepicker({
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
					instance = $( this ).data( "datepicker" ),
					date = $.datepicker.parseDate(
						instance.settings.dateFormat ||
						$.datepicker._defaults.dateFormat,
						selectedDate, instance.settings );
				dates.not( this ).datepicker( "option", option, date );
			}
		});
	});


function Buscar()
{
	var fecha_inicio = $("#from").val();
	var fecha_final = $("#to").val();
	var unidad_academica = $("#unca option:selected").val();
	var funcionario = $("#txtUsuario").val();
	if(fecha_inicio != "" ||fecha_final != "" || unidad_academica != 0 ||funcionario != ""  )
	{
	  $.ajax({
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
			$("#tableSpace").empty();
	}
}

function CrearTabla()
{
	var output ="";
	$("#tableSpace").empty();
	output+="<table id=\"myTable\" class=\"tablesorter\"><thead> <tr> <th>Numero De Boleta</th> <th>Dependencia</th> <th>Fecha de Prestamo</th> <th>Usuario</th></tr> </thead> <tbody> ";
	for (var i = 0;i<20 ;i++ )
	{
		output+="<tr><td>"+ i +"</td> <td>Dependencia"+i+"</td> <td>01/01/2010</td> <td>Usuario"+i+"</td></tr>";		 
	}
	output+="</tbody></table>";
	$("#tableSpace").append(output);
	$("#myTable").tablesorter(); 
	
	
	 
}





    