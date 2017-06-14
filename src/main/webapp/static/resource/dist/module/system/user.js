define("module/system/user",["app/common","app/datatables","app/form"],function(e,t,n){function u(t,r,i){if(t.selectedCount()!=1){e.info("\u8bf7\u9009\u62e9\u4e00\u6761\u9700\u8981\u4fee\u6539\u7684\u7528\u6237");return}$("#sys-user-password").removeClass("required"),n.editForm({title:"\u4fee\u6539\u7528\u6237",rules:s,fieldOpts:o,submitClear:!1,formData:t.selectedRows()[0],submitJson:!1,autoClose:!0,url:"ADMIN/system/user/edit",editModal:"#system-user-list-edit"},function(e){t.updateSelectedRow(e)}),$("#sys-user-password").attr("type","text"),$("#sys-user-password").val(""),$("#sys-user-password").attr("type","password")}function a(e){$("table#table-system-user-list").initTable({title:"\u7528\u6237\u8868",columns:i,footer:[{data:"loginName",title:"\u5408\u8ba1"},{data:"name",type:"count"},{data:"no",type:"sum",format:"0.00"}],params:e,permission:!0,checkboxSelect:!0,ordering:!1,info:!1,queryModal:"#system-user-query",rowOperation:[{operation:"updateUser",icon:"iconfont icon-edit",title:"\u4fee\u6539\u8bb0\u5f55"},{operation:"viewUser",text:"\u67e5\u770b"},"delete"],deleteRecord:{url:"ADMIN/system/user/delete",id:"id"},addRecord:function(e){$("#sys-user-password").hasClass("required")||$("#sys-user-password").addClass("required"),n.editForm({title:"\u65b0\u589e\u7528\u6237",submitClear:!0,rules:s,fieldOpts:o,url:"ADMIN/system/user/add",editModal:"#system-user-list-edit"},function(t){e.addRow(t)})},viewUser:function(e){n.editForm({title:"\u67e5\u770b\u7528\u6237",fieldOpts:o,formData:e.selectedRows()[0],editModal:"#system-user-list-edit",isView:!0})},updateUser:u},function(e){r=e})}function f(){$("#system-user-edit-form [name='company.id']").on("change",function(){$("#system-user-edit-form [name='company.name']").val($(this).children(":selected").text())}),$("#test-detail-1111").on("click",function(){e.loadInnerPage("system-user","pages/demo/datatable/main-detail/detail-table")})}var r,i=[{data:"id",title:"id",visible:!1},{data:"loginName",title:"\u767b\u5f55\u8d26\u53f7"},{data:"name",title:"\u59d3\u540d"},{data:"no",title:"\u5de5\u53f7"},{data:"email",title:"email"},{data:"company.name",title:"\u516c\u53f8"},{data:"remarks",title:"\u5907\u6ce8"}],s={loginName:{checkExists:{url:"ADMIN/system/user/checkLoginName"},messages:{checkExists:"\u767b\u5f55\u540d\u5df2\u5b58\u5728"}}},o={"company.id":{param:{type:"\u516c\u53f8"}},"dept.id":{param:{type:"\u90e8\u95e8"}},photo:{fileServer:"ADMIN",param:{type:"user"}}};return{inti_table:a,handleEdit:f,init:function(e){this.inti_table({company_id:"1"}),this.handleEdit()}}});