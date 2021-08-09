

function validationCustom(){
    var isValid;
    $(".input-data").each(function() {
       var element = $(this);
       if (element.val() == "") {
            $('.needs-validation').addClass("was-validated")
            return isValid = false;
       }else{
           return isValid = true;
       }
       
    });
    
    return isValid;
}