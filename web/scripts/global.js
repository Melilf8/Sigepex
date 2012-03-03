var eleIndexx = 0;

/* 
ACI Global Nav
*/
globalNav = {
	
	//ATTRIBUTES
	primaryMenu : {},
	secondaryMenu : {},	
	activeSecondaryMenu: 0,
	trayItems: 0,
	
	// PRIMARY NAV
	primaryNav : {	
		mouseOver: function (e){				
			/*$(this).find('a.btn-nav').addClass('hover');			*/
			if ($(this).find('a.btn-nav').is('#primary_Home') && $(this).hasClass('selected') == false ){
				$(this).find('.btn-nav img').attr('src','./App_Themes/ACI/images/nav/home-icon-white.png')
			} 
		},
		mouseOut: function () {			
			/*$(globalNav.primaryMenu).find('a.btn-nav').removeClass('hover');*/
			/*
			if ($(this).find('a.btn-nav').is('#primary_Home') && $(this).hasClass('selected') == false ){
				$(this).find('.btn-nav img').attr('src','/images/nav/home-icon-red.png')
			} */
			
		},		
		click: function(e){
			//e.preventDefault();			
			eleIndexx = $(this).index();	
			
			if ($(this).find('a.btn-nav').not('#primary_Home')){
				$(this).parent().find('.btn-nav img').attr('src','./App_Themes/ACI/images/nav/home-icon-white.png')
			}
			
			if ($(this).find('a.btn-nav').is('#primary_Home')){							
				$(this).find('.btn-nav img').attr('src','./App_Themes/ACI/images/nav/home-icon-red.png')
			}			
			
			globalNav.primaryMenu.removeClass('selected');
			$(this).addClass('selected');
			
			globalNav.secondaryNav.hideMenus();
			globalNav.activeSecondaryMenu = eleIndexx;
			globalNav.secondaryNav.changeMenuTo();
			
		},
		init : function(){
			
			globalNav.primaryMenu.bind({ 'click' : this.click, 'mouseover' : this.mouseOver } );
				//, 'mouseout' : this.mouseOut 
		}
	},
	
	// SECONDARY NAV
	secondaryNav : {
		hideMenus: function(){			
			$(globalNav.secondaryMenu).removeClass('selected').hide();	
		},
		changeMenuTo: function(event){		
			var menuToShow = $(globalNav.secondaryMenu).get(globalNav.activeSecondaryMenu);			
			$(menuToShow).show().addClass('selected');
		},
		mouseOver: function (e){		
					
			var trayContent = $(this).find('.trayContent');
					
			if ((trayContent).is('div.trayContent'))
			{
				globalNav.trayNav.content = trayContent;							
			}	
			else 
			{				
				return;
			}
				
			globalNav.trayNav.getHeight();			
			
			//show element tray if it is was selected before			
			if (trayContent.find('.columnRight ul.selected')){
				trayContent.find('.columnRight ul.selected').css('visibility','visible');
			}			
			
			trayContent.css('visibility','visible');		
			
		},
		mouseOut: function() {
			
			$(this).find('.trayContent div.columnRight ul').css('visibility','hidden');
			$(this).find('.trayContent').css('visibility','hidden');
			
		},		
		init : function(){
			
			$(globalNav.secondaryMenu).find('li').hoverIntent( this.mouseOver , this.mouseOut );
			
		}	
	},
	
	
	// TRAY CONTAINER
	trayNav : {
		content : {},
		trayheight : 0,		
		setDefaultTray: function(){
					
			globalNav.util.preloadImg('../images/nav/tray-bg.png');			
			$('.trayContent .columnLeft ul li:first-child').addClass('selected');						
			$('.trayContent .columnRight ul').not(':first-child').css('visibility','hidden');			
			$('.trayContent .columnRight ul:first-child').addClass('selected');
			
		},		
		mouseOverTrayItem: function(index) {
			
			
			
			var $event = $(this);
			
			$($event).parent().find('li').removeClass('selected');
			$($event).addClass('selected');		
			
			var eleIndex =  $($event).index();
									
			$event.parent().parent().next('div').find('ul').css('visibility','hidden').removeClass('selected');			
			var trayToShow = $event.parent().parent().next('div').find('ul').get(eleIndex);
						
			$(trayToShow).css('visibility', 'visible').addClass('selected');
			
		},
		getHeight :  function() {

			var columnLeft_h =  $(this.content).find('.columnLeft ul').innerHeight();
			var columnRigth_h =  $(this.content).find('.columnRight ul').innerHeight();
						
			if (columnLeft_h > columnRigth_h) 
			{
				this.trayheight = columnLeft_h;
			}
			else
			{			
				this.trayheight = columnRigth_h;
			}	
			
			$(this.content).height(this.trayheight);			
		},
		init: function() {
			
			this.setDefaultTray();			
			$(globalNav.trayItems).find('.columnLeft ul li').bind( {  'mouseover' : this.mouseOverTrayItem } )
		}	
	},	
	
	// UTILITIES
	util: {
		preloadImg: function(){
		  for(var i = 0; i<arguments.length; i++){
			jQuery("<img>").attr("src", arguments[i]);
		  }
		}
	},
	
selectMenu : function() {
    var pathName = window.location.pathname;
    pathName = pathName.substring(pathName.length,1);
    // Se agrega para el caso en que este en un directorio virtual
    var i = pathName.indexOf('/');
	pathName = pathName.substring(i+1);
    var ele = $('a[href="'+pathName+'"]');
    
     
                                
    globalNav.primaryMenu.removeClass('selected');
                                
    if (ele.parents('.secondaryMenu').length > 0 ){                                                
                    eleIndex = ele.parents('.secondaryMenu').index()-2;                                                   
                    $(globalNav.primaryMenu.get(eleIndex)).addClass('selected');              
    } else {                                                  
                    $(ele).parent().addClass('selected');                     
                    var eleIndex = $(ele).parent().index(); 
                    
                    if (eleIndex > 3 || pathName == 'terms_member.aspx') {
                      eleIndex=0;

                    }
                    if (eleIndex == -1)  {
                      eleIndex = 1;
                      $(globalNav.primaryMenu.get(eleIndex)).addClass('selected');
                    }
    }
                                
    if ($(ele).is('#primary_Home')){                                                                                                              
      $(ele).find('img').attr('src','images/nav/home-icon-red.png')
    }
                                
    globalNav.secondaryNav.hideMenus();
    globalNav.activeSecondaryMenu = eleIndex;
    globalNav.secondaryNav.changeMenuTo();
},
	
	// INIT GLOBAL NAV
	init : function() {		
		this.primaryMenu = $('#mainNav #primaryMenu ul li').not('#primary_howItWorks');
		this.secondaryMenu = $('#mainNav .secondaryMenu');
		this.trayItems = $('#mainNav .trayContent');
		//Initialization
		this.primaryNav.init();	
		this.secondaryNav.init();	
		this.trayNav.init();				
		
		this.selectMenu();
		
	}				
}

/* 
Global 
*/
appGlobal = {

    //HOME PAGE
    home: {
        randomize: function () {
            var bgImageTotal = 4;
            var randomNumber = Math.round(Math.random() * (bgImageTotal - 1)) + 1;
            var imgPath = ('images/home/bg' + randomNumber + '.jpg');
            $('body').css('background', ('url("' + imgPath + '") no-repeat center 130px transparent'));
        },
        init: function () {
            this.randomize();
            //appGlobal.forms.login();
            //appGlobal.forms.submit();
        }
    },

    forms: {

        login: function () {
            $('#btn-login').click(function (event) {
                event.preventDefault();
                alert('Handler for login Form called.');
                $('#frmLogin').submit();
            });
        },
        submit: function () {
            $('#btn-submit').click(function (event) {
                event.preventDefault();
                alert('Handler for submit Form called.');
                $('#frmSubmit').submit();
            });
        },
        signUp: function () {
            $('#btn_signUp').click(function (event) {
                event.preventDefault();
                alert('Handler for sign up Form called.');
                $('#frmSignUp').submit();
            });
        },
        submitContacUS: function () {
            $('#btn_submit').click(function (event) {
                event.preventDefault();
                alert('Handler for Contact Us called.');
                $('#frmContactUs').submit();
            });
        }
    },

    // SCROLL
    scroll: {
        deselect: function () {
            $('#floatdiv li a').removeClass('selected');
        },
        init: function () {
            var menu = $("#floatdiv");
            menu.addFloating({ snap: true, targetRight: 0, targetTop: 100 });

            $('#floatdiv li a').click(function () {
                appGlobal.scroll.deselect();
                appGlobal.scroll.select($(this));
            });

            // Window event
            //$(window).scroll(function(){
            //appGlobal.scroll.init();
            //});		
        }
    },




    	// TOOLTIPS	
	tooltip: {		
		sharedProperties : {
			position: {
				at: 'right center', // Position the tooltip above the link
				my: 'left center',
				viewport: $(window), // Keep the tooltip on-screen at all times
				effect: false // Disable positioning animation						
			},	
			show: {
				event: 'click',
				solo: true // Only show one tooltip at a time
			},
			hide: 'click',
			style: {
				classes: 'ui-tooltip-light uiui-tooltip-rounded ui-tooltip-shadow',						
				tip: {
					corner: true,							
					width: 23,
					height: 20											
				}
			},
            events: {
					  render: function(event, api) {
						 $(this).bind('mouseleave', function(e) {
							api.hide(e); 
						 });
					  }
				   }
		},		
		_220: function() {			
						
			$('.tooltip.220').each(function(){
				// We make use of the .each() loop to gain access to each element via the "this" keyword...				
				$(this).qtip( $.extend({}, appGlobal.tooltip.sharedProperties, { 
					content: {
						text: '<p>Loading...</p>', // The text to use whilst the AJAX request is loading						
						ajax: {
                            url: '_ProcessTooltip.aspx', // URL to the JSON script
                            type: 'GET', // POST or GET
                            data: { id: $(this).attr('rel')} // Data to pass along with your request
                        }
					},
					position: {
						at: 'left center', // Position the tooltip above the link
						my: 'right center',
						effect: false // Disable positioning animation							
					},
					hide: 'mouseout',
					style: {
						classes: 'ui-tooltip-light tooltip220 ui-tooltip-rounded ui-tooltip-shadow',						
						tip: {
							corner: true,							
							width: 20,
							height: 20											
						}
					},
                    events: {
					  render: function(event, api) {
						 $(this).bind('mouseleave', function(e) {
							api.hide(e); 
						 });
					  }
				   }	
				}));	
			})
		
		},
		_300: function() {			
						
			$('.tooltip.300').each(function(){
				// We make use of the .each() loop to gain access to each element via the "this" keyword...				
				$(this).qtip( $.extend({}, appGlobal.tooltip.sharedProperties, { 
					content: {
						text: '<p>Loading...</p>', // The text to use whilst the AJAX request is loading						
						ajax: {
				            url: '_ProcessTooltip.aspx', // URL to the JSON script
				            type: 'GET', // POST or GET
				            data: { id: $(this).attr('rel')} // Data to pass along with your request
				        }
					},
					position: {
						at: 'left center', // Position the tooltip above the link
						my: 'right center',
						effect: false // Disable positioning animation							
					},
					hide: 'mouseout',
					style: {
						classes: 'ui-tooltip-light tooltip300 uiui-tooltip-rounded ui-tooltip-shadow',						
						tip: {
							corner: true,							
							width: 20,
							height: 20											
						}
					},
                    events: {
					  render: function(event, api) {
						 $(this).bind('mouseleave', function(e) {
							api.hide(e); 
						 });
					  }
				   }	
				}));	
			})
		
		},
		_340: function (){
		
			$('.tooltip.340').each(function(){
				
				$(this).qtip(
				{
					position: {
						at: 'right center', // Position the tooltip above the link
						my: 'left center',
						viewport: $(window), // Keep the tooltip on-screen at all times
						effect: false // Disable positioning animation						
					},
					content: {
						text: '<p>Loading...</p>', // The text to use whilst the AJAX request is loading
						title: {
						  text: ' ',
						  button: true
					    },
						ajax: {
				            url: '_ProcessTooltip.aspx', // URL to the JSON script
				            type: 'GET', // POST or GET
				            data: { id: $(this).attr('rel')} // Data to pass along with your request
				        }
					},
					show: {
						event: 'click',
						solo: true // Only show one tooltip at a time
					},
					hide: 'click',
					style: {
						classes: 'ui-tooltip-light tooltip340 ui-tooltip-rounded ui-tooltip-shadow',						
						tip: {
							corner: true,							
							width: 23,
							height: 22					
						}
					},
                    events: {
					  render: function(event, api) {
						 $(this).bind('mouseleave', function(e) {
							api.hide(e); 
						 });
					  }
				   }
				})
			})		
			// Make sure it doesn't follow the link when we click it
			.click(function(event) { event.preventDefault(); });	
		},
		_600: function (){
		
			$('.tooltip.600').each(function(){
				
				$(this).qtip(
				{
					position: {
						at: 'right center', // Position the tooltip above the link
						my: 'left center',
						viewport: $(window), // Keep the tooltip on-screen at all times
						effect: false // Disable positioning animation						
					},
					content: {
						text: '<p>Loading...</p>', // The text to use whilst the AJAX request is loading
						title: {
						  text: ' ',
						  button: true
					    },
						ajax: {
				            url: '_ProcessTooltip.aspx', // URL to the JSON script
				            type: 'GET', // POST or GET
				            data: { id: $(this).attr('rel')} // Data to pass along with your request
				        }
					},
					show: {
						event: 'click',
						solo: true // Only show one tooltip at a time
					},
					hide: 'click',
					style: {
						classes: 'ui-tooltip-light tooltip600 ui-tooltip-rounded ui-tooltip-shadow',						
						tip: {
							corner: true,							
							width: 23,
							height: 22					
						}
					},
					events: {
					  render: function(event, api) {
						 $(this).bind('mouseleave', function(e) {
							api.hide(e); 
						 });
					  }
				   }
				})
			})	
			// Make sure it doesn't follow the link when we click it
			.click(function(event) { event.preventDefault(); });	
			
		},	
		init: function(){					
			
			if ($('.tooltip.220').length > 0){
				this._220(); 
			}			
			if ($('.tooltip.300').length > 0){
				this._300();
			}
			if ($('.tooltip.340').length > 0){
				this._340();
			}
			if ($('.tooltip.600').length > 0){
				this._600();
			}	
		}
	},

    // PROFILE FORM
    profile: {
        edit: function () {
            $('.editProfile .field input, .editProfile .field select').hide();
            $('#btnEdit').click(function (event) {
                event.preventDefault();
                $('.field span').hide();
                $('.field input, .field select').show();
                $('#btnSave').removeClass('btn-color-h37-inactive');
                $(this).addClass('btn-color-h37-inactive');
            });

            $('#btnSave').click(function (event) {
//                event.preventDefault();
//                $('.field span').show();
//                $('.field input,  .field select').hide();
//                $(this).addClass('btn-color-h37-inactive');
//                $('#btnEdit').removeClass('btn-color-h37-inactive');
                $('#btnSubmits').click();
            });

        },
        init: function () {
            this.edit();
        }
    },

    // CHECKBOXES 
    checkbox: {
        mkstyle: function () {
            $(".CheckBoxLabelClass").click(function (event) {
                event.preventDefault();
                if ($(this).hasClass("LabelSelected")) {
                    $(this).prev().attr('checked', true);
                    $(this).removeClass("LabelSelected");
                } else {
                    $(this).prev().attr('checked', false);
                    $(this).addClass("LabelSelected");
                }
            });
        },
        init: function () {
            this.mkstyle();
        }
    },

    // DROPDOWNS  
    dropdown: {
        mkstyle: function () {

            $(".dropdown").jqDropDown({
                //optionChanged: function(){alert('option changed...');}, 
                defaultStyle: false,
                toggleBtnName: 'toggleBtnName',
                optionListName: 'optionList',
                placeholder: 'frmSignUp',
                beforeToggle: function () {
                    $(this).next('.optionList').find('li:last-child').css('border-bottom', 'none');
                }
            });


        },
        init: function () {
            this.mkstyle();
        }
    },

    //Textbox
//    textbox: {
//        hideShowText: function () {
//            var textbox = $('input[type=text]');

//            $.each(textbox, function (key, value) {
//                var _this = $(this);
//                _this.attr('focus-value', _this.val());
//            });

//            $(textbox).focus(function () {
//                $(this).val('');
//            })
//			.focusout(function () {
//			    var text = $(this).val();

//			    if (text === '') {
//			        $(this).val($(this).attr('focus-value'));
//			    }
//			});

//        },
//        init: function () {
//            this.hideShowText();
//        }
//    }
}

/* Document Ready
************************************************************************/
$(document).ready(function () {

    // Nav
    if ($('#globalNav').length > 0) {
        globalNav.init();
        //console.log('global nav Object ready');
    }

    // Home
    if ($('#homeSignup').length > 0) {
        appGlobal.home.init();
        //console.log('Home Object ready');
    }

    // Scroll 
    if ($('#floatdiv').length > 0) {
        appGlobal.scroll.init();
        //console.log('Scroll Object ready');
    }

    // Profile Edit
    if ($('.editProfile').length > 0) {
        appGlobal.profile.init();
    }

    // Tooltip
    if ($('.tooltip').length > 0) {
        appGlobal.tooltip.init();
    }

    // Checkboxes	
    if ($('.CheckBoxLabelClass').length > 0) {
        appGlobal.checkbox.init();
    }

    // Dropdowns	
    if ($('.dropdown').length > 0) {
        appGlobal.dropdown.init();
    }

    // Textbox hide show value
    if ($('input[type=text]').length > 0) {
        //appGlobal.textbox.init();
    }

    // 
    if ($('#frmSignUp').length > 0) {
        appGlobal.forms.signUp();
    }

    if ($('#frmContactUs').length > 0) {
        appGlobal.forms.submitContacUS();
    }


});






