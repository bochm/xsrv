/*! Buttons for DataTables 1.2.2
 * ©2016 SpryMedia Ltd - datatables.net/license
 */

(function(e){typeof define=="function"&&define.amd?define(["jquery","datatables.net"],function(t){return e(t,window,document)}):typeof exports=="object"?module.exports=function(t,n){t||(t=window);if(!n||!n.fn.dataTable)n=require("datatables.net")(t,n).$;return e(n,t,t.document)}:e(jQuery,window,document)})(function(e,t,n,r){var i=e.fn.dataTable,s=0,o=0,u=i.ext.buttons,a=function(t,n){n===!0&&(n={}),e.isArray(n)&&(n={buttons:n}),this.c=e.extend(!0,{},a.defaults,n),n.buttons&&(this.c.buttons=n.buttons),this.s={dt:new i.Api(t),buttons:[],listenKeys:"",namespace:"dtb"+s++},this.dom={container:e("<"+this.c.dom.container.tag+"/>").addClass(this.c.dom.container.className)},this._constructor()};e.extend(a.prototype,{action:function(e,t){var n=this._nodeToButton(e);return t===r?n.conf.action:(n.conf.action=t,this)},active:function(t,n){var i=this._nodeToButton(t),s=this.c.dom.button.active,o=e(i.node);return n===r?o.hasClass(s):(o.toggleClass(s,n===r?!0:n),this)},add:function(e,t){var n=this.s.buttons;if(typeof t=="string"){var r=t.split("-"),i=this.s;for(var s=0,o=r.length-1;s<o;s++)i=i.buttons[r[s]*1];n=i.buttons,t=r[r.length-1]*1}return this._expandButton(n,e,!1,t),this._draw(),this},container:function(){return this.dom.container},disable:function(t){var n=this._nodeToButton(t);return e(n.node).addClass(this.c.dom.button.disabled),this},destroy:function(){e("body").off("keyup."+this.s.namespace);var t=this.s.buttons.slice(),n,r;for(n=0,r=t.length;n<r;n++)this.remove(t[n].node);this.dom.container.remove();var i=this.s.dt.settings()[0];for(n=0,r=i.length;n<r;n++)if(i.inst===this){i.splice(n,1);break}return this},enable:function(t,n){if(n===!1)return this.disable(t);var r=this._nodeToButton(t);return e(r.node).removeClass(this.c.dom.button.disabled),this},name:function(){return this.c.name},node:function(t){var n=this._nodeToButton(t);return e(n.node)},remove:function(t){var n=this._nodeToButton(t),r=this._nodeToHost(t),i=this.s.dt;if(n.buttons.length)for(var s=n.buttons.length-1;s>=0;s--)this.remove(n.buttons[s].node);n.conf.destroy&&n.conf.destroy.call(i.button(t),i,e(t),n.conf),this._removeKey(n.conf),e(n.node).remove();var o=e.inArray(n,r);return r.splice(o,1),this},text:function(t,n){var i=this._nodeToButton(t),s=this.c.dom.collection.buttonLiner,o=i.inCollection&&s&&s.tag?s.tag:this.c.dom.buttonLiner.tag,u=this.s.dt,a=e(i.node),f=function(e){return typeof e=="function"?e(u,a,i.conf):e};return n===r?f(i.conf.text):(i.conf.text=n,o?a.children(o).html(f(n)):a.html(f(n)),this)},_constructor:function(){var t=this,r=this.s.dt,i=r.settings()[0],s=this.c.buttons;i._buttons||(i._buttons=[]),i._buttons.push({inst:this,name:this.c.name});for(var o=0,u=s.length;o<u;o++)this.add(s[o]);r.on("destroy",function(){t.destroy()}),e("body").on("keyup."+this.s.namespace,function(e){if(!n.activeElement||n.activeElement===n.body){var r=String.fromCharCode(e.keyCode).toLowerCase();t.s.listenKeys.toLowerCase().indexOf(r)!==-1&&t._keypress(r,e)}})},_addKey:function(t){t.key&&(this.s.listenKeys+=e.isPlainObject(t.key)?t.key.key:t.key)},_draw:function(e,t){e||(e=this.dom.container,t=this.s.buttons),e.children().detach();for(var n=0,r=t.length;n<r;n++)e.append(t[n].inserter),t[n].buttons&&t[n].buttons.length&&this._draw(t[n].collection,t[n].buttons)},_expandButton:function(t,n,i,s){var o=this.s.dt,u=0,a=e.isArray(n)?n:[n];for(var f=0,l=a.length;f<l;f++){var c=this._resolveExtends(a[f]);if(!c)continue;if(e.isArray(c)){this._expandButton(t,c,i,s);continue}var h=this._buildButton(c,i);if(!h)continue;s!==r?(t.splice(s,0,h),s++):t.push(h);if(h.conf.buttons){var p=this.c.dom.collection;h.collection=e("<"+p.tag+"/>").addClass(p.className),h.conf._collection=h.collection,this._expandButton(h.buttons,h.conf.buttons,!0,s)}c.init&&c.init.call(o.button(h.node),o,e(h.node),c),u++}},_buildButton:function(t,n){var r=this.c.dom.button,i=this.c.dom.buttonLiner,s=this.c.dom.collection,u=this.s.dt,a=function(e){return typeof e=="function"?e(u,l,t):e};n&&s.button&&(r=s.button),n&&s.buttonLiner&&(i=s.buttonLiner);if(t.available&&!t.available(u,t))return!1;var f=function(t,n,r,i){i.action.call(n.button(r),t,n,r,i),e(n.table().node()).triggerHandler("buttons-action.dt",[n.button(r),n,r,i])},l=e("<"+r.tag+"/>").addClass(r.className).attr("tabindex",this.s.dt.settings()[0].iTabIndex).attr("aria-controls",this.s.dt.table().node().id).on("click.dtb",function(e){e.preventDefault(),!l.hasClass(r.disabled)&&t.action&&f(e,u,l,t),l.blur()}).on("keyup.dtb",function(e){e.keyCode===13&&!l.hasClass(r.disabled)&&t.action&&f(e,u,l,t)});r.tag.toLowerCase()==="a"&&l.attr("href","#");if(i.tag){var c=e("<"+i.tag+"/>").html(a(t.text)).addClass(i.className);i.tag.toLowerCase()==="a"&&c.attr("href","#"),l.append(c)}else l.html(a(t.text));t.enabled===!1&&l.addClass(r.disabled),t.className&&l.addClass(t.className),t.titleAttr&&l.attr("title",t.titleAttr),t.namespace||(t.namespace=".dt-button-"+o++);var h=this.c.dom.buttonContainer,p;return h&&h.tag?p=e("<"+h.tag+"/>").addClass(h.className).append(l):p=l,this._addKey(t),{conf:t,node:l.get(0),inserter:p,buttons:[],inCollection:n,collection:null}},_nodeToButton:function(e,t){t||(t=this.s.buttons);for(var n=0,r=t.length;n<r;n++){if(t[n].node===e)return t[n];if(t[n].buttons.length){var i=this._nodeToButton(e,t[n].buttons);if(i)return i}}},_nodeToHost:function(e,t){t||(t=this.s.buttons);for(var n=0,r=t.length;n<r;n++){if(t[n].node===e)return t;if(t[n].buttons.length){var i=this._nodeToHost(e,t[n].buttons);if(i)return i}}},_keypress:function(t,n){var r=function(r,i){if(!r.key)return;if(r.key===t)e(i).click();else if(e.isPlainObject(r.key)){if(r.key.key!==t)return;if(r.key.shiftKey&&!n.shiftKey)return;if(r.key.altKey&&!n.altKey)return;if(r.key.ctrlKey&&!n.ctrlKey)return;if(r.key.metaKey&&!n.metaKey)return;e(i).click()}},i=function(e){for(var t=0,n=e.length;t<n;t++)r(e[t].conf,e[t].node),e[t].buttons.length&&i(e[t].buttons)};i(this.s.buttons)},_removeKey:function(t){if(t.key){var n=e.isPlainObject(t.key)?t.key.key:t.key,r=this.s.listenKeys.split(""),i=e.inArray(n,r);r.splice(i,1),this.s.listenKeys=r.join("")}},_resolveExtends:function(t){var n=this.s.dt,i,s,o=function(i){var s=0;while(!e.isPlainObject(i)&&!e.isArray(i)){if(i===r)return;if(typeof i=="function"){i=i(n,t);if(!i)return!1}else if(typeof i=="string"){if(!u[i])throw"Unknown button type: "+i;i=u[i]}s++;if(s>30)throw"Buttons: Too many iterations"}return e.isArray(i)?i:e.extend({},i)};t=o(t);while(t&&t.extend){if(!u[t.extend])throw"Cannot extend unknown button type: "+t.extend;var a=o(u[t.extend]);if(e.isArray(a))return a;if(!a)return!1;var f=a.className;t=e.extend({},a,t),f&&t.className!==f&&(t.className=f+" "+t.className);var l=t.postfixButtons;if(l){t.buttons||(t.buttons=[]);for(i=0,s=l.length;i<s;i++)t.buttons.push(l[i]);t.postfixButtons=null}var c=t.prefixButtons;if(c){t.buttons||(t.buttons=[]);for(i=0,s=c.length;i<s;i++)t.buttons.splice(i,0,c[i]);t.prefixButtons=null}t.extend=a.extend}return t}}),a.background=function(t,n,i){i===r&&(i=400),t?e("<div/>").addClass(n).css("display","none").appendTo("body").fadeIn(i):e("body > div."+n).fadeOut(i,function(){e(this).removeClass(n).remove()})},a.instanceSelector=function(t,n){if(!t)return e.map(n,function(e){return e.inst});var r=[],i=e.map(n,function(e){return e.name}),s=function(t){if(e.isArray(t)){for(var o=0,u=t.length;o<u;o++)s(t[o]);return}if(typeof t=="string")if(t.indexOf(",")!==-1)s(t.split(","));else{var a=e.inArray(e.trim(t),i);a!==-1&&r.push(n[a].inst)}else typeof t=="number"&&r.push(n[t].inst)};return s(t),r},a.buttonSelector=function(t,n){var i=[],s=function(e,t,n){var i,o;for(var u=0,a=t.length;u<a;u++)i=t[u],i&&(o=n!==r?n+u:u+"",e.push({node:i.node,name:i.conf.name,idx:o}),i.buttons&&s(e,i.buttons,o+"-"))},o=function(t,n){var u,a,f=[];s(f,n.s.buttons);var l=e.map(f,function(e){return e.node});if(e.isArray(t)||t instanceof e){for(u=0,a=t.length;u<a;u++)o(t[u],n);return}if(t===null||t===r||t==="*")for(u=0,a=f.length;u<a;u++)i.push({inst:n,node:f[u].node});else if(typeof t=="number")i.push({inst:n,node:n.s.buttons[t].node});else if(typeof t=="string")if(t.indexOf(",")!==-1){var c=t.split(",");for(u=0,a=c.length;u<a;u++)o(e.trim(c[u]),n)}else if(t.match(/^\d+(\-\d+)*$/)){var h=e.map(f,function(e){return e.idx});i.push({inst:n,node:f[e.inArray(t,h)].node})}else if(t.indexOf(":name")!==-1){var p=t.replace(":name","");for(u=0,a=f.length;u<a;u++)f[u].name===p&&i.push({inst:n,node:f[u].node})}else e(l).filter(t).each(function(){i.push({inst:n,node:this})});else if(typeof t=="object"&&t.nodeName){var d=e.inArray(t,l);d!==-1&&i.push({inst:n,node:l[d]})}};for(var u=0,a=t.length;u<a;u++){var f=t[u];o(n,f)}return i},a.defaults={buttons:["copy","excel","csv","pdf","print"],name:"main",tabIndex:0,dom:{container:{tag:"div",className:"dt-buttons"},collection:{tag:"div",className:"dt-button-collection"},button:{tag:"a",className:"dt-button",active:"active",disabled:"disabled"},buttonLiner:{tag:"span",className:""}}},a.version="1.2.2",e.extend(u,{collection:{text:function(e){return e.i18n("buttons.collection","Collection")},className:"buttons-collection",action:function(n,r,i,s){var o=i,u=o.offset(),f=e(r.table().container()),l=!1;e("div.dt-button-background").length&&(l=e("div.dt-button-collection").offset(),e("body").trigger("click.dtb-collection")),s._collection.addClass(s.collectionLayout).css("display","none").appendTo("body").fadeIn(s.fade);var c=s._collection.css("position");if(l&&c==="absolute")s._collection.css({top:l.top+5,left:l.left+5});else if(c==="absolute"){s._collection.css({top:u.top+o.outerHeight(),left:u.left});var h=u.left+s._collection.outerWidth(),p=f.offset().left+f.width();h>p&&s._collection.css("left",u.left-(h-p))}else{var d=s._collection.height()/2;d>e(t).height()/2&&(d=e(t).height()/2),s._collection.css("marginTop",d*-1)}s.background&&a.background(!0,s.backgroundClassName,s.fade),setTimeout(function(){e("div.dt-button-background").on("click.dtb-collection",function(){}),e("body").on("click.dtb-collection",function(t){var n=e.fn.addBack?"addBack":"andSelf";e(t.target).parents()[n]().filter(s._collection).length||(s._collection.fadeOut(s.fade,function(){s._collection.detach()}),e("div.dt-button-background").off("click.dtb-collection"),a.background(!1,s.backgroundClassName,s.fade),e("body").off("click.dtb-collection"),r.off("buttons-action.b-internal"))})},10),s.autoClose&&r.on("buttons-action.b-internal",function(){e("div.dt-button-background").click()})},background:!0,collectionLayout:"",backgroundClassName:"dt-button-background",autoClose:!1,fade:400},copy:function(e,t){if(u.copyHtml5)return"copyHtml5";if(u.copyFlash&&u.copyFlash.available(e,t))return"copyFlash"},csv:function(e,t){if(u.csvHtml5&&u.csvHtml5.available(e,t))return"csvHtml5";if(u.csvFlash&&u.csvFlash.available(e,t))return"csvFlash"},excel:function(e,t){if(u.excelHtml5&&u.excelHtml5.available(e,t))return"excelHtml5";if(u.excelFlash&&u.excelFlash.available(e,t))return"excelFlash"},pdf:function(e,t){if(u.pdfHtml5&&u.pdfHtml5.available(e,t))return"pdfHtml5";if(u.pdfFlash&&u.pdfFlash.available(e,t))return"pdfFlash"},pageLength:function(t){var n=t.settings()[0].aLengthMenu,r=e.isArray(n[0])?n[0]:n,i=e.isArray(n[0])?n[1]:n,s=function(e){return e.i18n("buttons.pageLength",{"-1":"Show all rows",_:"Show %d rows"},e.page.len())};return{extend:"collection",text:s,className:"buttons-page-length",autoClose:!0,buttons:e.map(r,function(e,t){return{text:i[t],action:function(t,n){n.page.len(e).draw()},init:function(t,n,r){var i=this,s=function(){i.active(t.page.len()===e)};t.on("length.dt"+r.namespace,s),s()},destroy:function(e,t,n){e.off("length.dt"+n.namespace)}}}),init:function(e,t,n){var r=this;e.on("length.dt"+n.namespace,function(){r.text(s(e))})},destroy:function(e,t,n){e.off("length.dt"+n.namespace)}}}}),i.Api.register("buttons()",function(e,t){t===r&&(t=e,e=r),this.selector.buttonGroup=e;var n=this.iterator(!0,"table",function(n){if(n._buttons)return a.buttonSelector(a.instanceSelector(e,n._buttons),t)},!0);return n._groupSelector=e,n}),i.Api.register("button()",function(e,t){var n=this.buttons(e,t);return n.length>1&&n.splice(1,n.length),n}),i.Api.registerPlural("buttons().active()","button().active()",function(e){return e===r?this.map(function(e){return e.inst.active(e.node)}):this.each(function(t){t.inst.active(t.node,e)})}),i.Api.registerPlural("buttons().action()","button().action()",function(e){return e===r?this.map(function(e){return e.inst.action(e.node)}):this.each(function(t){t.inst.action(t.node,e)})}),i.Api.register(["buttons().enable()","button().enable()"],function(e){return this.each(function(t){t.inst.enable(t.node,e)})}),i.Api.register(["buttons().disable()","button().disable()"],function(){return this.each(function(e){e.inst.disable(e.node)})}),i.Api.registerPlural("buttons().nodes()","button().node()",function(){var t=e();return e(this.each(function(e){t=t.add(e.inst.node(e.node))})),t}),i.Api.registerPlural("buttons().text()","button().text()",function(e){return e===r?this.map(function(e){return e.inst.text(e.node)}):this.each(function(t){t.inst.text(t.node,e)})}),i.Api.registerPlural("buttons().trigger()","button().trigger()",function(){return this.each(function(e){e.inst.node(e.node).trigger("click")})}),i.Api.registerPlural("buttons().containers()","buttons().container()",function(){var t=e(),n=this._groupSelector;return this.iterator(!0,"table",function(e){if(e._buttons){var r=a.instanceSelector(n,e._buttons);for(var i=0,s=r.length;i<s;i++)t=t.add(r[i].container())}}),t}),i.Api.register("button().add()",function(e,t){var n=this.context;if(n.length){var r=a.instanceSelector(this._groupSelector,n[0]._buttons);r.length&&r[0].add(t,e)}return this.button(this._groupSelector,e)}),i.Api.register("buttons().destroy()",function(){return this.pluck("inst").unique().each(function(e){e.destroy()}),this}),i.Api.registerPlural("buttons().remove()","buttons().remove()",function(){return this.each(function(e){e.inst.remove(e.node)}),this});var f;i.Api.register("buttons.info()",function(t,n,i){var s=this;return t===!1?(e("#datatables_buttons_info").fadeOut(function(){e(this).remove()}),clearTimeout(f),f=null,this):(f&&clearTimeout(f),e("#datatables_buttons_info").length&&e("#datatables_buttons_info").remove(),t=t?"<h2>"+t+"</h2>":"",e('<div id="datatables_buttons_info" class="dt-button-info"/>').html(t).append(e("<div/>")[typeof n=="string"?"html":"append"](n)).css("display","none").appendTo("body").fadeIn(),i!==r&&i!==0&&(f=setTimeout(function(){s.buttons.info(!1)},i)),this)}),i.Api.register("buttons.exportData()",function(e){if(this.context.length)return c(new i.Api(this.context[0]),e)});var l=e("<textarea/>")[0],c=function(t,n){var r=e.extend(!0,{},{rows:null,columns:"",modifier:{search:"applied",order:"applied"},orthogonal:"display",stripHtml:!0,stripNewlines:!0,decodeEntities:!0,trim:!0,format:{header:function(e){return i(e)},footer:function(e){return i(e)},body:function(e){return i(e)}}},n),i=function(e){return typeof e!="string"?e:(r.stripHtml&&(e=e.replace(/<[^>]*>/g,"")),r.trim&&(e=e.replace(/^\s+|\s+$/g,"")),r.stripNewlines&&(e=e.replace(/\n/g," ")),r.decodeEntities&&(l.innerHTML=e,e=l.value),e)},s=t.columns(r.columns).indexes().map(function(e){var n=t.column(e).header();return r.format.header(n.innerHTML,e,n)}).toArray(),o=t.table().footer()?t.columns(r.columns).indexes().map(function(e){var n=t.column(e).footer();return r.format.footer(n?n.innerHTML:"",e,n)}).toArray():null,u=t.rows(r.rows,r.modifier).indexes().toArray(),a=t.cells(u,r.columns).render(r.orthogonal).toArray(),f=t.cells(u,r.columns).nodes().toArray(),c=s.length,h=c>0?a.length/c:0,p=new Array(h),d=0;for(var v=0,m=h;v<m;v++){var g=new Array(c);for(var y=0;y<c;y++)g[y]=r.format.body(a[d],v,y,f[d]),d++;p[v]=g}return{header:s,footer:o,body:p}};return e.fn.dataTable.Buttons=a,e.fn.DataTable.Buttons=a,e(n).on("init.dt plugin-init.dt",function(e,t){if(e.namespace!=="dt")return;var n=t.oInit.buttons||i.defaults.buttons;n&&!t._buttons&&(new a(t,n)).container()}),i.ext.feature.push({fnInit:function(e){var t=new i.Api(e),n=t.init().buttons||i.defaults.buttons;return(new a(t,n)).container()},cFeature:"B"}),a});