/**
* hoverIntent r6 // 2011.02.26 // jQuery 1.5.1+
* <http://cherne.net/brian/resources/jquery.hoverIntent.html>
* 
* @param  f  onMouseOver function || An object with configuration options
* @param  g  onMouseOut function  || Nothing (use configuration options object)
* @author    Brian Cherne brian(at)cherne(dot)net
*/
(function($){$.fn.hoverIntent=function(f,g){var cfg={sensitivity:7,interval:100,timeout:0};cfg=$.extend(cfg,g?{over:f,out:g}:f);var cX,cY,pX,pY;var track=function(ev){cX=ev.pageX;cY=ev.pageY};var compare=function(ev,ob){ob.hoverIntent_t=clearTimeout(ob.hoverIntent_t);if((Math.abs(pX-cX)+Math.abs(pY-cY))<cfg.sensitivity){$(ob).unbind("mousemove",track);ob.hoverIntent_s=1;return cfg.over.apply(ob,[ev])}else{pX=cX;pY=cY;ob.hoverIntent_t=setTimeout(function(){compare(ev,ob)},cfg.interval)}};var delay=function(ev,ob){ob.hoverIntent_t=clearTimeout(ob.hoverIntent_t);ob.hoverIntent_s=0;return cfg.out.apply(ob,[ev])};var handleHover=function(e){var ev=jQuery.extend({},e);var ob=this;if(ob.hoverIntent_t){ob.hoverIntent_t=clearTimeout(ob.hoverIntent_t)}if(e.type=="mouseenter"){pX=ev.pageX;pY=ev.pageY;$(ob).bind("mousemove",track);if(ob.hoverIntent_s!=1){ob.hoverIntent_t=setTimeout(function(){compare(ev,ob)},cfg.interval)}}else{$(ob).unbind("mousemove",track);if(ob.hoverIntent_s==1){ob.hoverIntent_t=setTimeout(function(){delay(ev,ob)},cfg.timeout)}}};return this.bind('mouseenter',handleHover).bind('mouseleave',handleHover)}})(jQuery);

/*
 * jquery.jscroll. The jQuery scroll plugin
 *
 */


(function($){$.fn.jScroll=function(e){var f=$.extend({},$.fn.jScroll.defaults,e);return this.each(function(){var a=$(this);var b=$(window);var c=new location(a);b.scroll(function(){a.stop().animate(c.getMargin(b),f.speed)})});function location(d){this.min=d.offset().top;this.originalMargin=parseInt(d.css("margin-top"),10)||0;this.getMargin=function(a){var b=d.parent().height()-d.outerHeight();var c=this.originalMargin;if(a.scrollTop()>=this.min)c=c+f.top+a.scrollTop()-this.min;if(c>b)c=b;return({"marginTop":c+'px'})}}};$.fn.jScroll.defaults={speed:"slow",top:10}})(jQuery);



/*********************************************************************

jqDropDown v1.0
http://uraniuminteractive.com

Copyright 2011, Frank Parent for Uranium Interactive
Free to use and abuse under the MIT license.
http://www.opensource.org/licenses/mit-license.php

+ February 2011 - Module creation

**********************************************************************/

(function(f,c){var g=function(k,j){var n=f(k),j=f.extend({},f.fn.jqDropDown.defaults,j),q,s,o=j.defaultOption,m,i,l,t=j.effect,p=j.effectSpeed,r=f('<ul class="'+j.optionListName+'" style="display:none;"></ul>');q=n.width();n.hide().after('<div class="'+j.containerName+'" style="position:relative;"></div>');if(o&&o!==""){m=o}else{m=n.find("option[selected]").text()||n.find("option:eq(0)").text()}i=f('<a href="#" class="'+j.toggleBtnName+'">'+m+"</a>");s=n.next("div."+j.containerName);s.append(i);r.append(d(n,j));l=r.find("a");i.after(r);h(s,q,j);f(document).bind("mousedown",function(w){var v=this,u=f(w.target);if(f(document.activeElement).hasClass(j.toggleBtnName)||f(document.activeElement).hasClass(j.optionListName)){if(!u.hasClass(j.optionGroupName)&&!u.hasClass(j.toggleBtnName)){if(u.parents().filter(r).length){i.data("index",r.find("li").index(u.parent())).focus();e(n,u);b(i,u,j);j.optionChanged(u)}else{if(f(document.activeElement).hasClass(j.toggleBtnName)&&r.is(":visible").length){t==="fade"?r.fadeOut(p):r.hide();return false}else{if(f(document.activeElement).hasClass(j.toggleBtnName)&&!r.filter(":visible").length){i.blur();return false}else{if(j.modal){return false}}}}t==="fade"?r.fadeOut(p):r.hide();return false}else{return false}}});l.bind("mouseenter click",function(v){var u=f(this);v.preventDefault();r.find("a.selected").removeClass("selected");u.addClass("selected");i.data("index",r.find("li").index(u.parent()))});i.bind("mousedown keydown focusout click",function(z){var A=f(this),D,u=A.data("index")||0,w=false,C=false,v,y=r.find("a"),B;if(z.type==="mousedown"&&z.which===1){j.beforeToggle.call(this);a(A,r,j);y.removeClass("selected");A.focus();r.find("li:eq("+u+") a").addClass("selected");if(r.is(":hidden")){t==="fade"?f("."+j.optionListName).fadeOut(p):f("."+j.optionListName).hide();t==="fade"?r.fadeIn(p):r.show()}else{t==="fade"?r.fadeOut(p):r.hide()}j.afterToggle.call(this)}if(z.type==="keydown"){switch(z.keyCode){case 9:C=true;t==="fade"?r.fadeOut(p):r.hide();break;case 27:C=true;t==="fade"?r.fadeOut(p):r.hide();break;case 13:f(document).trigger("mousedown",[{target:r.find("li:eq("+A.data("index")+") a:eq(0)")}]);break;case 38:z.preventDefault();y.removeClass("selected");for(var x=u-1;x>=0;x--){D=r.find("li:eq("+(x)+")");if(!D.hasClass(j.optionGroupName)){u=x;break}}break;case 40:z.preventDefault();y.removeClass("selected");for(var x=u+1;x<r.find("li").length;x++){D=r.find("li:eq("+(x)+")");if(!D.hasClass(j.optionGroupName)){u=x;break}}break;default:B=String.fromCharCode(z.which).toLowerCase();for(var x=u+1;x<r.find("li").length;x++){D=r.find("li:eq("+(x)+")");if(D.text().slice(0,1).toLowerCase()===B&&!D.hasClass(j.optionGroupName)){y.removeClass("selected");u=x;w=true;break}}if(!w){for(var x=0;x<u;x++){D=r.find("li:eq("+(x)+")");if(D.text().slice(0,1).toLowerCase()===B&&!D.hasClass(j.optionGroupName)){y.removeClass("selected");u=x;break}}}break}if(!C){A.data("index",u);v=r.find("li:eq("+A.data("index")+") a:eq(0)");v.addClass("selected");e(n,$target);b(A,v,j)}}else{return false}})};function e(j,i){var k=i.attr("rel")||i.text();j.find("option").each(function(){var l=f(this);if(l.val()===k||l.text()===k){l.trigger("select").attr("selected",true)}})}function b(i,j,k){var l,m;if(j&&j.text()!==""){i.text(j.text()).append("<span></span>")}if(k.placeholder){l=f(k.placeholder);k.useValue?m=j.attr("rel"):m=j.text();if(l.is("input")){l.val(m)}else{l.text(m)}}}function d(m,o){var k,n,p="",j,l="";if(o.data.length){k=o.data}else{k=m.find("option,optgroup")}if(o.defaultOption&&o.defaultOption!==""){p+='<li class="'+o.optionName+'"><a href="#">'+o.defaultOption+"</a></li>"}for(n=0;n<k.length;n++){j=f(k[n]);if(j.is(":selected")&&!o.defaultOption){l="selected"}if(j.is("option")){p+='<li class="'+o.optionName+'"><a class="'+l+'" href="#" rel="'+j.attr("value")+'">'+j.text()+"</a></li>"}else{p+='<li class="'+o.optionGroupName+'">'+j.attr("label")+"</li>"}l=""}return p}function h(p,i,o){var k=p.find("ul:eq(0)"),n=p.find("ul > li > a"),j=p.find("a:eq(0)"),m=parseInt(j.css("padding-left"),10)+parseInt(j.css("padding-right"),10),l;a(j,k,o);if(o.defaultStyle){p.find("li."+o.optionGroupName).length>0?l=20:l=4;k.css({width:i+m});j.css({width:k.width()-m}).append("<span></span>");n.css({"padding-left":l})}}function a(k,n,l){var o,q,i,m=f("select"),j,p;q=parseInt(k.css("padding-top"),10)+parseInt(k.css("padding-bottom"),10)||0;i=parseInt(k.css("border-top-width"),10)+parseInt(k.css("border-bottom-width"),10)||0;if(p==="up"||(k.offset().top+n.height()+20)>f(c).height()+f(c).scrollTop()){o=-(n.height()+q-i);p="up"}else{o=k.height()+q+i;p="down"}n.css({top:o});if(f.browser.msie&&f.browser.version==="6.0"||f.browser.version==="7.0"){p==="up"?j=0:j=m.length;m.each(function(){f(this).next("div").css({"z-index":j});if(p==="up"){j+=1}else{j-=1}})}}f.fn.jqDropDown=function(i){return this.each(function(){var j=f(this);if(j.data("jqDropDown")){return}var k=new g(this,i);j.data("jqDropDown",k)})};f.fn.jqDropDown.Debug=function(i){if(c.console&&c.console.log){c.console.log("hilight selection count: "+i.text())}};f.fn.jqDropDown.defaults={effect:"default",effectSpeed:400,modal:false,data:{},defaultOption:null,containerName:"ddContainer",toggleBtnName:"ddToggle",optionListName:"ddOptionList",optionGroupName:"optgroup",optionName:"ddOption",defaultStyle:true,placeholder:null,useValue:true,direction:"down",beforeToggle:function(){},afterToggle:function(){},optionChanged:function(){}}}(jQuery,window,undefined));


/* Script by: www.jtricks.com
 * Version: 1.7 (20110408)
 * Latest version: www.jtricks.com/javascript/navigation/floating.html
 */
var floatingMenu =
{
    hasInner: typeof(window.innerWidth) == 'number',
    hasElement: typeof(document.documentElement) == 'object'
        && typeof(document.documentElement.clientWidth) == 'number'
};

var floatingArray =
[
];

floatingMenu.add = function(obj, options)
{
    var name;
    var menu;

    if (typeof(obj) === "string")
        name = obj;
    else
        menu = obj;
        

    if (options == undefined)
    {
        floatingArray.push( 
            {
                id: name,
                menu: menu,

                targetLeft: 0,
                targetTop: 0,

                distance: .07,
                snap: true
            });
    }
    else
    {
        floatingArray.push( 
            {
                id: name,
                menu: menu,

                targetLeft: options.targetLeft,
                targetRight: options.targetRight,
                targetTop: options.targetTop,
                targetBottom: options.targetBottom,

                centerX: options.centerX,
                centerY: options.centerY,

                prohibitXMovement: options.prohibitXMovement,
                prohibitYMovement: options.prohibitYMovement,

                distance: options.distance != undefined ? options.distance : .07,
                snap: options.snap,
                ignoreParentDimensions: options.ignoreParentDimensions,

                scrollContainer: options.scrollContainer,
                scrollContainerId: options.scrollContainerId
            });
    }
};

floatingMenu.findSingle = function(item)
{
    if (item.id)
        item.menu = document.getElementById(item.id);

    if (item.scrollContainerId)
        item.scrollContainer = document.getElementById(item.scrollContainerId);
};

floatingMenu.move = function (item)
{
    if (!item.prohibitXMovement)
    {
        item.menu.style.left = item.nextX + 'px';
        item.menu.style.right = '';
    }

    if (!item.prohibitYMovement)
    {
        item.menu.style.top = item.nextY + 'px';
        item.menu.style.bottom = '';
    }
};

floatingMenu.scrollLeft = function(item)
{
    // If floating within scrollable container use it's scrollLeft
    if (item.scrollContainer)
        return item.scrollContainer.scrollLeft;

    var w = window;

    // Find top window scroll parameters if we're IFRAMEd
    while (w != w.parent)
        w = w.parent;

    return this.hasInner
        ? w.pageXOffset  
        : this.hasElement  
          ? w.document.documentElement.scrollLeft  
          : w.document.body.scrollLeft;
};

floatingMenu.scrollTop = function(item)
{
    // If floating within scrollable container use it's scrollTop
    if (item.scrollContainer)
        return item.scrollContainer.scrollTop;

    var w = window;

    // Find top window scroll parameters if we're IFRAMEd
    while (w != w.parent)
        w = w.parent;

    return this.hasInner
        ? w.pageYOffset
        : this.hasElement
          ? w.document.documentElement.scrollTop
          : w.document.body.scrollTop;
};

floatingMenu.windowWidth = function()
{
    return this.hasElement
        ? document.documentElement.clientWidth
        : document.body.clientWidth;
};

floatingMenu.windowHeight = function()
{
    if (floatingMenu.hasElement && floatingMenu.hasInner)
    {
        // Handle Opera 8 problems
        return document.documentElement.clientHeight > window.innerHeight
            ? window.innerHeight
            : document.documentElement.clientHeight
    }
    else
    {
        return floatingMenu.hasElement
            ? document.documentElement.clientHeight
            : document.body.clientHeight;
    }
};

floatingMenu.documentHeight = function()
{
    var innerHeight = this.hasInner
        ? window.innerHeight
        : 0;

    var body = document.body,
        html = document.documentElement;

    return Math.max(
        body.scrollHeight,
        body.offsetHeight, 
        html.clientHeight,
        html.scrollHeight,
        html.offsetHeight,
        innerHeight);
};

floatingMenu.documentWidth = function()
{
    var innerWidth = this.hasInner
        ? window.innerWidth
        : 0;

    var body = document.body,
        html = document.documentElement;

    return Math.max(
        body.scrollWidth,
        body.offsetWidth, 
        html.clientWidth,
        html.scrollWidth,
        html.offsetWidth,
        innerWidth);
};

floatingMenu.calculateCornerX = function(item)
{
    var offsetWidth = item.menu.offsetWidth;

    if (item.centerX)
        return this.scrollLeft(item) + (this.windowWidth() - offsetWidth)/2;

    var result = this.scrollLeft(item) - item.parentLeft;
    if (item.targetLeft == undefined)
    {
        result += this.windowWidth() - item.targetRight - offsetWidth;
    }
    else
    {
        result += item.targetLeft;
    }
        
    if (document.body != item.menu.parentNode
        && result + offsetWidth >= item.confinedWidthReserve)
    {
        result = item.confinedWidthReserve - offsetWidth;
    }

    if (result < 0)
        result = 0;

    return result;
};

floatingMenu.calculateCornerY = function(item)
{
    var offsetHeight = item.menu.offsetHeight;

    if (item.centerY)
        return this.scrollTop(item) + (this.windowHeight() - offsetHeight)/2;

    var result = this.scrollTop(item) - item.parentTop;
    if (item.targetTop === undefined)
    {
        result += this.windowHeight() - item.targetBottom - offsetHeight;
    }
    else
    {
        result += item.targetTop;
    }

    if (document.body != item.menu.parentNode
        && result + offsetHeight >= item.confinedHeightReserve)
    {
        result = item.confinedHeightReserve - offsetHeight;
    }

    if (result < 0)
        result = 0;
        
    return result;
};

floatingMenu.computeParent = function(item)
{
    if (item.ignoreParentDimensions)
    {
        item.confinedHeightReserve = this.documentHeight();
        item.confinedWidthReserver = this.documentWidth();
        item.parentLeft = 0;  
        item.parentTop = 0;  
        return;
    }

    var parentNode = item.menu.parentNode;
    var parentOffsets = this.offsets(parentNode, item);
    item.parentLeft = parentOffsets.left;
    item.parentTop = parentOffsets.top;

    item.confinedWidthReserve = parentNode.clientWidth;

    // We could have absolutely-positioned DIV wrapped
    // inside relatively-positioned. Then parent might not
    // have any height. Try to find parent that has
    // and try to find whats left of its height for us.
    var obj = parentNode;
    var objOffsets = this.offsets(obj, item);
    while (obj.clientHeight + objOffsets.top
           < item.menu.offsetHeight + parentOffsets.top)
    {
        obj = obj.parentNode;
        objOffsets = this.offsets(obj, item);
    }

    item.confinedHeightReserve = obj.clientHeight
        - (parentOffsets.top - objOffsets.top);
};

floatingMenu.offsets = function(obj, item)
{
    var result =
    {
        left: 0,
        top: 0
    };

    if (obj === item.scrollContainer)
        return;

    while (obj.offsetParent && obj.offsetParent != item.scrollContainer)
    {  
        result.left += obj.offsetLeft;  
        result.top += obj.offsetTop;  
        obj = obj.offsetParent;
    }  

    if (window == window.parent)
        return result;

    // we're IFRAMEd
    var iframes = window.parent.document.body.getElementsByTagName("IFRAME");
    for (var i = 0; i < iframes.length; i++)
    {
        if (iframes[i].contentWindow != window)
           continue;

        obj = iframes[i];
        while (obj.offsetParent)  
        {  
            result.left += obj.offsetLeft;  
            result.top += obj.offsetTop;  
            obj = obj.offsetParent;
        }  
    }

    return result;
};

floatingMenu.doFloatSingle = function(item)
{
    this.findSingle(item);

    var stepX, stepY;

    this.computeParent(item);

    var cornerX = this.calculateCornerX(item);

    var stepX = (cornerX - item.nextX) * item.distance;
    if (Math.abs(stepX) < .5 && item.snap
        || Math.abs(cornerX - item.nextX) == 1)
    {
        stepX = cornerX - item.nextX;
    }

    var cornerY = this.calculateCornerY(item);

    var stepY = (cornerY - item.nextY) * item.distance;
    if (Math.abs(stepY) < .5 && item.snap
        || Math.abs(cornerY - item.nextY) == 1)
    {
        stepY = cornerY - item.nextY;
    }

    if (Math.abs(stepX) > 0 ||
        Math.abs(stepY) > 0)
    {
        item.nextX += stepX;
        item.nextY += stepY;
        this.move(item);
    }
};

floatingMenu.fixTargets = function()
{
};

floatingMenu.fixTarget = function(item)
{
};

floatingMenu.doFloat = function()
{
    this.fixTargets();
    for (var i=0; i < floatingArray.length; i++)
    {
        this.fixTarget(floatingArray[i]);
        this.doFloatSingle(floatingArray[i]);
    }
    setTimeout('floatingMenu.doFloat()', 20);
};

floatingMenu.insertEvent = function(element, event, handler)
{
    // W3C
    if (element.addEventListener != undefined)
    {
        element.addEventListener(event, handler, false);
        return;
    }

    var listener = 'on' + event;

    // MS
    if (element.attachEvent != undefined)
    {
        element.attachEvent(listener, handler);
        return;
    }

    // Fallback
    var oldHandler = element[listener];
    element[listener] = function (e)
        {
            e = (e) ? e : window.event;
            var result = handler(e);
            return (oldHandler != undefined) 
                && (oldHandler(e) == true)
                && (result == true);
        };
};

floatingMenu.init = function()
{
    floatingMenu.fixTargets();

    for (var i=0; i < floatingArray.length; i++)
    {
        floatingMenu.initSingleMenu(floatingArray[i]);
    }

    setTimeout('floatingMenu.doFloat()', 100);
};

// Some browsers init scrollbars only after
// full document load.
floatingMenu.initSingleMenu = function(item)
{
    this.findSingle(item);
    this.computeParent(item);
    this.fixTarget(item);
    item.nextX = this.calculateCornerX(item);
    item.nextY = this.calculateCornerY(item);
    this.move(item);
};

floatingMenu.insertEvent(window, 'load', floatingMenu.init);


// Register ourselves as jQuery plugin if jQuery is present
if (typeof(jQuery) !== 'undefined')
{
    (function ($)
    {
        $.fn.addFloating = function(options)
        {
            return this.each(function()
            {
                floatingMenu.add(this, options);
            });
        };
    }) (jQuery);
}

