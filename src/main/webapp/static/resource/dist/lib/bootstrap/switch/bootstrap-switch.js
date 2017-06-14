/**
 * bootstrap-switch - Turn checkboxes and radio buttons into toggle switches.
 *
 * @version v3.3.4
 * @homepage https://bttstrp.github.io/bootstrap-switch
 * @author Mattia Larentis <mattia@larentis.eu> (http://larentis.eu)
 * @license Apache-2.0
 */

(function(e,t){if(typeof define=="function"&&define.amd)define(["jquery"],t);else if(typeof exports!="undefined")t(require("jquery"));else{var n={exports:{}};t(e.jquery),e.bootstrapSwitch=n.exports}})(this,function(e){"use strict";function n(e){return e&&e.__esModule?e:{"default":e}}function i(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}var t=n(e),r=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var n=arguments[t];for(var r in n)Object.prototype.hasOwnProperty.call(n,r)&&(e[r]=n[r])}return e},s=function(){function e(e,t){for(var n=0;n<t.length;n++){var r=t[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(e,r.key,r)}}return function(t,n,r){return n&&e(t.prototype,n),r&&e(t,r),t}}(),o=t.default||window.jQuery||window.$,u=function(){function e(t){var n=this,r=arguments.length>1&&arguments[1]!==undefined?arguments[1]:{};i(this,e),this.$element=o(t),this.options=o.extend({},o.fn.bootstrapSwitch.defaults,this._getElementOptions(),r),this.prevOptions={},this.$wrapper=o("<div>",{"class":function(){var t=[];return t.push(n.options.state?"on":"off"),n.options.size&&t.push(n.options.size),n.options.disabled&&t.push("disabled"),n.options.readonly&&t.push("readonly"),n.options.indeterminate&&t.push("indeterminate"),n.options.inverse&&t.push("inverse"),n.$element.attr("id")&&t.push("id-"+n.$element.attr("id")),t.map(n._getClass.bind(n)).concat([n.options.baseClass],n._getClasses(n.options.wrapperClass)).join(" ")}}),this.$container=o("<div>",{"class":this._getClass("container")}),this.$on=o("<span>",{html:this.options.onText,"class":this._getClass("handle-on")+" "+this._getClass(this.options.onColor)}),this.$off=o("<span>",{html:this.options.offText,"class":this._getClass("handle-off")+" "+this._getClass(this.options.offColor)}),this.$label=o("<span>",{html:this.options.labelText,"class":this._getClass("label")}),this.$element.on("init.bootstrapSwitch",this.options.onInit.bind(this,t)),this.$element.on("switch:change",function(){for(var e=arguments.length,r=Array(e),i=0;i<e;i++)r[i]=arguments[i];n.options.onSwitchChange.apply(t,r)===!1&&(n.$element.is(":radio")?o('[name="'+n.$element.attr("name")+'"]').trigger("previousState.bootstrapSwitch",!0):n.$element.trigger("previousState.bootstrapSwitch",!0))}),this.$container=this.$element.wrap(this.$container).parent(),this.$wrapper=this.$container.wrap(this.$wrapper).parent(),this.$element.before(this.options.inverse?this.$off:this.$on).before(this.$label).before(this.options.inverse?this.$on:this.$off),this.options.indeterminate&&this.$element.prop("indeterminate",!0),this._init(),this._elementHandlers(),this._handleHandlers(),this._labelHandlers(),this._formHandler(),this._externalLabelHandler(),this.$element.trigger("init.bootstrapSwitch",this.options.state)}return s(e,[{key:"setPrevOptions",value:function(){this.prevOptions=r({},this.options)}},{key:"state",value:function(t,n){return typeof t=="undefined"?this.options.state:this.options.disabled||this.options.readonly||this.options.state&&!this.options.radioAllOff&&this.$element.is(":radio")?this.$element:(this.$element.is(":radio")?o('[name="'+this.$element.attr("name")+'"]').trigger("setPreviousOptions.bootstrapSwitch"):this.$element.trigger("setPreviousOptions.bootstrapSwitch"),this.options.indeterminate&&this.indeterminate(!1),this.$element.prop("checked",Boolean(t)).trigger("change.bootstrapSwitch",n),this.$element)}},{key:"toggleState",value:function(t){return this.options.disabled||this.options.readonly?this.$element:this.options.indeterminate?(this.indeterminate(!1),this.state(!0)):this.$element.prop("checked",!this.options.state).trigger("change.bootstrapSwitch",t)}},{key:"size",value:function(t){return typeof t=="undefined"?this.options.size:(this.options.size!=null&&this.$wrapper.removeClass(this._getClass(this.options.size)),t&&this.$wrapper.addClass(this._getClass(t)),this._width(),this._containerPosition(),this.options.size=t,this.$element)}},{key:"animate",value:function(t){return typeof t=="undefined"?this.options.animate:this.options.animate===Boolean(t)?this.$element:this.toggleAnimate()}},{key:"toggleAnimate",value:function(){return this.options.animate=!this.options.animate,this.$wrapper.toggleClass(this._getClass("animate")),this.$element}},{key:"disabled",value:function(t){return typeof t=="undefined"?this.options.disabled:this.options.disabled===Boolean(t)?this.$element:this.toggleDisabled()}},{key:"toggleDisabled",value:function(){return this.options.disabled=!this.options.disabled,this.$element.prop("disabled",this.options.disabled),this.$wrapper.toggleClass(this._getClass("disabled")),this.$element}},{key:"readonly",value:function(t){return typeof t=="undefined"?this.options.readonly:this.options.readonly===Boolean(t)?this.$element:this.toggleReadonly()}},{key:"toggleReadonly",value:function(){return this.options.readonly=!this.options.readonly,this.$element.prop("readonly",this.options.readonly),this.$wrapper.toggleClass(this._getClass("readonly")),this.$element}},{key:"indeterminate",value:function(t){return typeof t=="undefined"?this.options.indeterminate:this.options.indeterminate===Boolean(t)?this.$element:this.toggleIndeterminate()}},{key:"toggleIndeterminate",value:function(){return this.options.indeterminate=!this.options.indeterminate,this.$element.prop("indeterminate",this.options.indeterminate),this.$wrapper.toggleClass(this._getClass("indeterminate")),this._containerPosition(),this.$element}},{key:"inverse",value:function(t){return typeof t=="undefined"?this.options.inverse:this.options.inverse===Boolean(t)?this.$element:this.toggleInverse()}},{key:"toggleInverse",value:function(){this.$wrapper.toggleClass(this._getClass("inverse"));var t=this.$on.clone(!0),n=this.$off.clone(!0);return this.$on.replaceWith(n),this.$off.replaceWith(t),this.$on=n,this.$off=t,this.options.inverse=!this.options.inverse,this.$element}},{key:"onColor",value:function(t){return typeof t=="undefined"?this.options.onColor:(this.options.onColor&&this.$on.removeClass(this._getClass(this.options.onColor)),this.$on.addClass(this._getClass(t)),this.options.onColor=t,this.$element)}},{key:"offColor",value:function(t){return typeof t=="undefined"?this.options.offColor:(this.options.offColor&&this.$off.removeClass(this._getClass(this.options.offColor)),this.$off.addClass(this._getClass(t)),this.options.offColor=t,this.$element)}},{key:"onText",value:function(t){return typeof t=="undefined"?this.options.onText:(this.$on.html(t),this._width(),this._containerPosition(),this.options.onText=t,this.$element)}},{key:"offText",value:function(t){return typeof t=="undefined"?this.options.offText:(this.$off.html(t),this._width(),this._containerPosition(),this.options.offText=t,this.$element)}},{key:"labelText",value:function(t){return typeof t=="undefined"?this.options.labelText:(this.$label.html(t),this._width(),this.options.labelText=t,this.$element)}},{key:"handleWidth",value:function(t){return typeof t=="undefined"?this.options.handleWidth:(this.options.handleWidth=t,this._width(),this._containerPosition(),this.$element)}},{key:"labelWidth",value:function(t){return typeof t=="undefined"?this.options.labelWidth:(this.options.labelWidth=t,this._width(),this._containerPosition(),this.$element)}},{key:"baseClass",value:function(t){return this.options.baseClass}},{key:"wrapperClass",value:function(t){return typeof t=="undefined"?this.options.wrapperClass:(t||(t=o.fn.bootstrapSwitch.defaults.wrapperClass),this.$wrapper.removeClass(this._getClasses(this.options.wrapperClass).join(" ")),this.$wrapper.addClass(this._getClasses(t).join(" ")),this.options.wrapperClass=t,this.$element)}},{key:"radioAllOff",value:function(t){if(typeof t=="undefined")return this.options.radioAllOff;var n=Boolean(t);return this.options.radioAllOff===n?this.$element:(this.options.radioAllOff=n,this.$element)}},{key:"onInit",value:function(t){return typeof t=="undefined"?this.options.onInit:(t||(t=o.fn.bootstrapSwitch.defaults.onInit),this.options.onInit=t,this.$element)}},{key:"onSwitchChange",value:function(t){return typeof t=="undefined"?this.options.onSwitchChange:(t||(t=o.fn.bootstrapSwitch.defaults.onSwitchChange),this.options.onSwitchChange=t,this.$element)}},{key:"destroy",value:function(){var t=this.$element.closest("form");return t.length&&t.off("reset.bootstrapSwitch").removeData("bootstrap-switch"),this.$container.children().not(this.$element).remove(),this.$element.unwrap().unwrap().off(".bootstrapSwitch").removeData("bootstrap-switch"),this.$element}},{key:"_getElementOptions",value:function(){return{state:this.$element.is(":checked"),size:this.$element.data("size"),animate:this.$element.data("animate"),disabled:this.$element.is(":disabled"),readonly:this.$element.is("[readonly]"),indeterminate:this.$element.data("indeterminate"),inverse:this.$element.data("inverse"),radioAllOff:this.$element.data("radio-all-off"),onColor:this.$element.data("on-color"),offColor:this.$element.data("off-color"),onText:this.$element.data("on-text"),offText:this.$element.data("off-text"),labelText:this.$element.data("label-text"),handleWidth:this.$element.data("handle-width"),labelWidth:this.$element.data("label-width"),baseClass:this.$element.data("base-class"),wrapperClass:this.$element.data("wrapper-class")}}},{key:"_width",value:function(){var t=this,n=this.$on.add(this.$off).add(this.$label).css("width",""),r=this.options.handleWidth==="auto"?Math.round(Math.max(this.$on.width(),this.$off.width())):this.options.handleWidth;return n.width(r),this.$label.width(function(e,n){return t.options.labelWidth!=="auto"?t.options.labelWidth:n<r?r:n}),this._handleWidth=this.$on.outerWidth(),this._labelWidth=this.$label.outerWidth(),this.$container.width(this._handleWidth*2+this._labelWidth),this.$wrapper.width(this._handleWidth+this._labelWidth)}},{key:"_containerPosition",value:function(){var t=this,n=arguments.length>0&&arguments[0]!==undefined?arguments[0]:this.options.state,r=arguments[1];this.$container.css("margin-left",function(){var e=[0,"-"+t._handleWidth+"px"];return t.options.indeterminate?"-"+t._handleWidth/2+"px":n?t.options.inverse?e[1]:e[0]:t.options.inverse?e[0]:e[1]})}},{key:"_init",value:function(){var t=this,n=function(){t.setPrevOptions(),t._width(),t._containerPosition(),setTimeout(function(){if(t.options.animate)return t.$wrapper.addClass(t._getClass("animate"))},50)};if(this.$wrapper.is(":visible")){n();return}var r=window.setInterval(function(){if(t.$wrapper.is(":visible"))return n(),window.clearInterval(r)},50)}},{key:"_elementHandlers",value:function(){var t=this;return this.$element.on({"setPreviousOptions.bootstrapSwitch":this.setPrevOptions.bind(this),"previousState.bootstrapSwitch":function(){t.options=t.prevOptions,t.options.indeterminate&&t.$wrapper.addClass(t._getClass("indeterminate")),t.$element.prop("checked",t.options.state).trigger("change.bootstrapSwitch",!0)},"change.bootstrapSwitch":function(n,r){n.preventDefault(),n.stopImmediatePropagation();var i=t.$element.is(":checked");t._containerPosition(i);if(i===t.options.state)return;t.options.state=i,t.$wrapper.toggleClass(t._getClass("off")).toggleClass(t._getClass("on")),r||(t.$element.is(":radio")&&o('[name="'+t.$element.attr("name")+'"]').not(t.$element).prop("checked",!1).trigger("change.bootstrapSwitch",!0),t.$element.trigger("switch:change",[i]))},"focus.bootstrapSwitch":function(n){n.preventDefault(),t.$wrapper.addClass(t._getClass("focused"))},"blur.bootstrapSwitch":function(n){n.preventDefault(),t.$wrapper.removeClass(t._getClass("focused"))},"keydown.bootstrapSwitch":function(n){if(!n.which||t.options.disabled||t.options.readonly)return;if(n.which===37||n.which===39)n.preventDefault(),n.stopImmediatePropagation(),t.state(n.which===39)}})}},{key:"_handleHandlers",value:function(){var t=this;return this.$on.on("click.bootstrapSwitch",function(e){return e.preventDefault(),e.stopPropagation(),t.state(!1),t.$element.trigger("focus.bootstrapSwitch")}),this.$off.on("click.bootstrapSwitch",function(e){return e.preventDefault(),e.stopPropagation(),t.state(!0),t.$element.trigger("focus.bootstrapSwitch")})}},{key:"_labelHandlers",value:function(){var t=this,n={click:function(t){t.stopPropagation()},"mousedown.bootstrapSwitch touchstart.bootstrapSwitch":function(n){if(t._dragStart||t.options.disabled||t.options.readonly)return;n.preventDefault(),n.stopPropagation(),t._dragStart=(n.pageX||n.originalEvent.touches[0].pageX)-parseInt(t.$container.css("margin-left"),10),t.options.animate&&t.$wrapper.removeClass(t._getClass("animate")),t.$element.trigger("focus.bootstrapSwitch")},"mousemove.bootstrapSwitch touchmove.bootstrapSwitch":function(n){if(t._dragStart==null)return;var r=(n.pageX||n.originalEvent.touches[0].pageX)-t._dragStart;n.preventDefault();if(r<-t._handleWidth||r>0)return;t._dragEnd=r,t.$container.css("margin-left",t._dragEnd+"px")},"mouseup.bootstrapSwitch touchend.bootstrapSwitch":function(n){if(!t._dragStart)return;n.preventDefault(),t.options.animate&&t.$wrapper.addClass(t._getClass("animate"));if(t._dragEnd){var r=t._dragEnd>-(t._handleWidth/2);t._dragEnd=!1,t.state(t.options.inverse?!r:r)}else t.state(!t.options.state);t._dragStart=!1},"mouseleave.bootstrapSwitch":function(){t.$label.trigger("mouseup.bootstrapSwitch")}};this.$label.on(n)}},{key:"_externalLabelHandler",value:function(){var t=this,n=this.$element.closest("label");n.on("click",function(e){e.preventDefault(),e.stopImmediatePropagation(),e.target===n[0]&&t.toggleState()})}},{key:"_formHandler",value:function(){var t=this.$element.closest("form");if(t.data("bootstrap-switch"))return;t.on("reset.bootstrapSwitch",function(){window.setTimeout(function(){t.find("input").filter(function(){return o(this).data("bootstrap-switch")}).each(function(){return o(this).bootstrapSwitch("state",this.checked)})},1)}).data("bootstrap-switch",!0)}},{key:"_getClass",value:function(t){return this.options.baseClass+"-"+t}},{key:"_getClasses",value:function(t){return o.isArray(t)?t.map(this._getClass.bind(this)):[this._getClass(t)]}}]),e}();o.fn.bootstrapSwitch=function(e){function i(t,r){var i=o(r),s=i.data("bootstrap-switch"),a=s||new u(r,e);return s||i.data("bootstrap-switch",a),typeof e=="string"?a[e].apply(a,n):t}for(var t=arguments.length,n=Array(t>1?t-1:0),r=1;r<t;r++)n[r-1]=arguments[r];return Array.prototype.reduce.call(this,i,this)},o.fn.bootstrapSwitch.Constructor=u,o.fn.bootstrapSwitch.defaults={state:!0,size:null,animate:!0,disabled:!1,readonly:!1,indeterminate:!1,inverse:!1,radioAllOff:!1,onColor:"primary",offColor:"default",onText:"\u662f",offText:"\u5426",labelText:"&nbsp",handleWidth:"auto",labelWidth:"auto",baseClass:"bootstrap-switch",wrapperClass:"wrapper",onInit:function(){},onSwitchChange:function(){}}});