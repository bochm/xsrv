define("module/system/dict",["app/common","app/api","app/datatables","app/form"],function(e,t,n,r){function i(e){$("table#table-system-dict-list").initTable({order:[2,"asc"],queryModal:{id:"#system-dict-query",url:"pages/system/dict/dict-query"},deleteRecord:{url:"ADMIN/system/dict/delete",id:"id"},addEditForm:{addUrl:"ADMIN/system/dict/add",editUrl:"ADMIN/system/dict/edit",title:"\u5b57\u5178\u7ef4\u62a4",editModal:"#system-dict-list-edit",rules:{name:{checkExists:{stmid:"cn.bx.system.mapper.DictMapper.checkTypes",joinField:["#system-dict-edit-form-type"]},messages:{checkExists:"\u5df2\u5b58\u5728\u8be5\u540d\u79f0"}},value:{checkExists:{stmid:"cn.bx.system.mapper.DictMapper.checkTypes",joinField:"#system-dict-edit-form-type"},messages:{checkExists:"\u5df2\u5b58\u5728\u8be5\u503c"}}}}},function(e){$("#system-dict-edit-form [name='type']").on("change",function(){$("#system-dict-edit-form [name='typeDesc']").val($("#system-dict-edit-form [name='type'] :selected").text())})})}return{inti_table:i,init:function(e){this.inti_table(e)}}});