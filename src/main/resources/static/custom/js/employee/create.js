
 var employee = {};
 var department = {};
 
 
function createEmployee(){
    $.ajax({
        url : '/emp/create-modal',
        dataType : "html",
        type : 'get',
        success : function(e){
            if ($('.modal-body-content').length){
                $('.modal-body-content').remove();
                
            }
            $('#data-modal').append(e);
            $('.modal').modal('show');
        }
    })
}

function setForm(){
    department.id = $('select[name="department"] option').filter(':selected').val();
    employee.name = $('input[name="username"]').val();
    employee.last_name = $('input[name="lastname"]').val();
    employee.email = $('input[name="email"]').val();
    employee.address = $('textarea[name="address"]').val();
    employee.department = department;
}

function postCreateEmployee(){
    if(validationCustom()){
        setForm();
        $.ajax({
            url : 'http://localhost:8085/emp',
            data : JSON.stringify(employee),
            contentType: "application/json",
            type : 'POST',
            dataType : 'json',
            success : function(e){
                if(e.message == "Success"){
                    succesAlert("Data Employee Berhasil Dibuat");
                    data.ajax.reload( null, false );
                    $('.modal').modal('hide');
                }
            } ,error : function(e){
                $('.modal').modal('hide');
                var a = e.responseJSON.message;
                errorAlert(a)
            }       
        })       
    }
}

function updateEmployee(id){
    $.ajax({
        url : '/emp/update-modal/' + id,
        dataType : 'html',
        type : 'get',
        success : function(e){
            console.log(e);
            if ($('.modal-body-content').length){
                $('.modal-body-content').remove();
            }
            $('#data-modal').append(e);
            $('.modal').modal('show');
        }
    })
}

function postUpdateEmployee(id){
    if(validationCustom()){
        setForm();
        $.ajax({
            url : 'http://localhost:8085/emp/' + id,
            data : JSON.stringify(employee),
            type : 'put',
            contentType: "application/json",
            dataType : 'json',
            success : function(e){
                data.ajax.reload( null, false );
                succesAlert(e.message);
                $('.modal').modal('hide');
            },
            error : function(e){
                Swal.fire({
                        position: 'top-end',
                        icon: 'error',
                        title: "Terjadi Error",
                        showConfirmButton: false,
                        timer: 1500
                    })
                $('.modal').modal('hide');
            }
        })
    }else{
        $('.needs-validation').addClass("was-validated")
    }
}

function deleteEmployee(id){
    questionAlert("Data dengan id : "+id+" akan terhapus", "Hapus", ()=>{
        $.ajax({
            url : 'http://localhost:8085/emp/'+id,
            dataType : 'json',
            type : 'delete',
            success : function (e){
                    succesAlert("Berhasil terhapus");
                    data.ajax.reload( null, false );
            },error: (e)=>{
                errorAlert("Terjadi Error Mohon Hubungi Pengembang");
            }
        })
    })
}

function viewEmployee(id){
    $.ajax({
    url : '/emp/update-modal/' + id,
    dataType : 'html',
    type : 'get',
    success : function(e){
            console.log(e);
            if ($('.modal-body-content').length){
                $('.modal-body-content').remove();
            }
            $('#data-modal').append(e);
            $('.input-data').prop("disabled", true)
            $('.btn-action').hide()
            $('.modal').modal('show');
        }
    })
}