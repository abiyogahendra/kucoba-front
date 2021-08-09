
$(document).ready(function (e){
    $('.active').removeClass('active');
    $('#side-employee').addClass('active');
  })
var data = $('#table_employee').DataTable({
    ajax : {
        url : 'http://localhost:8085/emp',
        dataSrc : ''
    },
    "columns": [ 
        {"targets": 0,
          "data": "id",
          "render": function ( data, type, row, meta ) {
            return '<div class="row center"><div class="col">'+data+'</div></div>';
          }
        },
        {"targets": 1,
          "data": "name",
          "render": function ( data, type, row, meta ) {
            return '<div class="row center"><div class="col">'+data+'</div></div>';
          }
        },
        {"targets": 2,
          "data": "last_name",
          "render": function ( data, type, row, meta ) {
            return '<div class="row center"><div class="col">'+data+'</div></div>';
          }
        },
        {"targets": 3,
          "data": "email",
          "render": function ( data, type, row, meta ) {
            return '<div class="row center"><div class="col">'+data+'</div></div>';
          }
        },
        {"targets": 4,
          "data": "address",
          "render": function ( data, type, row, meta ) {
            return '<div class="row center"><div class="col">'+data+'</div></div>';
          }
        },
        {"targets": 5,
          "data": "department.name",
          "render": function ( data, type, row, meta ) {
            return '<div class="row center"><div class="col">'+data+'</div></div>';
          }
        },
        {"targets": 6,
          "data": "id",
          "render": function ( data, type, row, meta ) {
            return '<div class="d-flex justify-content-center">\n\
                        <a href="#" onclick="updateEmployee('+data+')"><i class="fas fa-edit"></i></a> | \n\
                        <a href="#" onclick="viewEmployee('+data+')"><i class="fa fa-sm fa-eye"></i></a> | \n\
                        <a href="#" onclick="deleteEmployee('+data+')"><i class="fas fa-trash-alt"></i></a> \n\
                    </div>';
          }
        }
    ]
});
// setInterval( function () {
//    data.ajax.reload( null, false ); // user paging is not reset on reload
//}, 2000 );