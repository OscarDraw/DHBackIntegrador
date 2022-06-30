window.addEventListener('load', function () {

    const form = document.querySelector('#new-appointment');

    form.addEventListener('submit', function (event) {

        const formData = {
            firstName: document.querySelector('#input-first-name').value,
            lastName: document.querySelector('#input-last-name').value,
            userName: document.querySelector('#input-user-name').value,
            password: document.querySelector('#input-password').value,
            email: document.querySelector('#input-email').value,
            address:{
                streetName: document.querySelector('#input-street-name').value,
                streetNumber: document.querySelector('#input-street-number').value,
                city: document.querySelector('#input-city').value,
                state: document.querySelector('#input-state').value,
            }
        };

        const url = '/patient/create';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Paciente agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {
                    //Si hay algun error se muestra un mensaje diciendo que el odontologo
                    //no se pudo guardar y se intente nuevamente
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     //se dejan todos los campos vacíos por si se quiere ingresar otro paciente
                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#input-first-name').value = "";
        document.querySelector('#input-last-name').value = "";
        document.querySelector('#input-user-name').value = "";
        document.querySelector('#input-password').value = "";
        document.querySelector('#input-email').value = "";
        document.querySelector('#input-street-name').value = "";
        document.querySelector('#input-street-number').value = "";
        document.querySelector('#input-city').value = "";
        document.querySelector('#input-state').value = "";

    }

//    (function(){
//        let pathname = window.location.pathname;
//        if(pathname === "/"){
//            document.querySelector(".nav .nav-item a:first").addClass("active");
//        } else if (pathname == "/odontologoList.html") {
//            document.querySelector(".nav .nav-item a:last").addClass("active");
//        }
//    })();
});