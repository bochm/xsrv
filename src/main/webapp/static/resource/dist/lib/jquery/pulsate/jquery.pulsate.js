(function(e){var t={init:function(t){var r={color:e(this).css("background-color"),reach:20,speed:1e3,pause:0,glow:!0,repeat:!0,onHover:!1};return e(this).css({"-moz-outline-radius":e(this).css("border-top-left-radius"),"-webkit-outline-radius":e(this).css("border-top-left-radius"),"outline-radius":e(this).css("border-top-left-radius")}),t&&e.extend(r,t),r.color=e("<div style='background:"+r.color+"'></div>").css("background-color"),r.repeat!==!0&&!isNaN(r.repeat)&&r.repeat>0&&(r.repeat-=1),this.each(function(){r.onHover?e(this).bind("mouseover",function(){n(r,this,0)}).bind("mouseout",function(){e(this).pulsate("destroy")}):n(r,this,0)})},destroy:function(){return this.each(function(){clearTimeout(this.timer),e(this).css("outline",0)})}},n=function(t,i,s){var o=t.reach,s=s>o?0:s,u=(o-s)/o,a=t.color.split(","),f="rgba("+a[0].split("(")[1]+","+a[1]+","+a[2].split(")")[0]+","+u+")",l={outline:"2px solid "+f};t.glow?(l["box-shadow"]="0px 0px "+parseInt(s/1.5)+"px "+f,userAgent=navigator.userAgent||"",/(chrome)[ \/]([\w.]+)/.test(userAgent.toLowerCase())&&(l["outline-offset"]=s+"px",l["outline-radius"]="100 px")):l["outline-offset"]=s+"px",e(i).css(l);var c=function(){if(s>=o&&!t.repeat)return e(i).pulsate("destroy"),!1;if(s>=o&&t.repeat!==!0&&!isNaN(t.repeat)&&t.repeat>0)t.repeat=t.repeat-1;else if(t.pause&&s>=o)return r(t,i,s+1),!1;n(t,i,s+1)};i.timer=setTimeout(c,t.speed/o)},r=function(e,t,r){innerfunc=function(){n(e,t,r)},setTimeout(innerfunc,e.pause)};e.fn.pulsate=function(n){if(t[n])return t[n].apply(this,Array.prototype.slice.call(arguments,1));if(typeof n=="object"||!n)return t.init.apply(this,arguments);e.error("Method "+n+" does not exist on jQuery.pulsate")}})(jQuery);