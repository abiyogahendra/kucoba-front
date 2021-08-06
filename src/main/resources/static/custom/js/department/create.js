function createModal(){
    $.ajax({
        url : '/department/create-modal',
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

function postCreateDepartment(){
    var data = $('input[name=name]').val()
    if(data){
        $.ajax({
            url : '/department/add',
            data : {
                name : data
                },
            type : 'post',
            dataType : 'json',
            success : function(e){
                console.log(e)
            }        
        })
    }else{
        $('.needs-validation').addClass("was-validated")
    }
    
}


function updateModal(id){
    $.ajax({
        url : '/department/update-modal/' + id,
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

function postUpdateDepartment(id){
    var data = $('input[name=name]').val()
    if(data){
        $.ajax({
            url : '/department/update/' + id,
            data : {
                name : data
                },
            type : 'put',
            dataType : 'json',
            success : function(e){
                if(e.code == 200){
                    Swal.fire({
                        position: 'top-end',
                        icon: 'success',
                        title: e.response,
                        showConfirmButton: false,
                        timer: 1500
                    })
                    $('.modal').modal('hide');
                }
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