var data = $('#table_department').DataTable({
    ajax : {
        url : '/department/get-data-department',
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
          "data": "id",
          "render": function ( data, type, row, meta ) {
            return '<div class="d-flex justify-content-center"><a href="#" onclick="updateModal('+data+')"><i class="fas fa-edit"></i></a> | <a href="#" onclick="deleteDepartment('+data+')"><i class="fas fa-trash-alt"></i></a> </div>';
          }
        }
    ]
});
// setInterval( function () {
    //     data.ajax.reload( null, false ); // user paging is not reset on reload
    // }, 2000 );
