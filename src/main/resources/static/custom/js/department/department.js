$(document).ready(function (e){
  $('.active').removeClass('active');
  $('#side-department').addClass('active');
})
var data = $('#table_department').DataTable({
    ajax : {
        url : 'http://localhost:8085/department',
        dataSrc : ''
    },
    "columns": [ 
        {"name": "Id",
          "data": "id",
          "render": function ( data, type, row, meta ) {
            return '<div class="row center"><div class="col">'+data+'</div></div>';
          }
        },
        {"name": "Department Name",
          "data": "name",
          "render": function ( data, type, row, meta ) {
            return '<div class="row center"><div class="col">'+data+'</div></div>';
          }
        },
        {"name": "Action",
          "data": "id",
          "render": function ( data, type, row, meta ) {
            return '<div class="d-flex justify-content-center">\n\
                        <a href="#" onclick="updateModal('+data+')"><i class="fas fa-edit"></i></a> | \n\
                        <a href="#" onclick="deleteDepartment('+data+')"><i class="fas fa-trash-alt"></i></a> \n\
                    </div>';
          }
        }
    ]
});
// setInterval( function () {
//    data.ajax.reload( null, false ); // user paging is not reset on reload
//}, 2000 );
