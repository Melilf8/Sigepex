var salvarUpdate = 1;//Salvar = 1, Update = 2

jQuery(document).ready(function () {
    initDialog();
});


   
   function initDialog()
   {
       jQuery("#_dialogTP").dialog({
           modal: true,
           autoOpen: false,
           width: 500,
           resizable: false,
           draggable: false,
           buttons: {
               "close": {
                   text: 'Cerrar',
                   'class': 'blue',
                   click: function () {
                       jQuery(this).dialog("close");
                   }
               },
               "save": {
                   text: 'Salvar',
                   'class': 'blue',
                   click: function () {
                       if (salvarUpdate == 1) {
                           AgregarValor();
                       } else {
                       }
                       jQuery(this).dialog("close");
                   }
               }
           }
       });

       jQuery("#btnNew").click(function () {
           salvarUpdate = 1;
           jQuery("#_dialogTP").dialog("open");
       });

   }

   function AgregarValor() {

       var output = "<li id=\"" + jQuery("#txtNuevoValor").val() + "\"><div class=\"divLi\"><div class=\"liText\"><span id=\"Valor\">" + jQuery("#txtNuevoValor").val() + "</span></div><div class=\"btnIcons\"><img src=\"/Sigepex/css2/Reportes/images/pencil.png\" class=\"icons_edit\" alt=\"Editar\" title=\"" + jQuery("#txtNuevoValor").val() + "\" /><img src=\"/Sigepex/css2/Reportes/images/x.png\" class=\"icons\" alt=\"Eliminar\" title=\"" + jQuery("#txtNuevoValor").val() + "\" onClick=\" Remove('" + jQuery("#txtNuevoValor").val() + "')\" /></div></div><div class=\"clear\"></div> </li>";
       jQuery("#txtNuevoValor").val("");
       jQuery("#listaValores").append(output);
   }

   function Remove(id) {
       jQuery('#' + id).remove();
   }
      