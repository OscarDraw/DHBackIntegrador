window.addEventListener('load', function () {
    const form = document.querySelector('#new-dentist');

    form.addEventListener('submit', function (event) {

        let name = document.querySelector("#name")
        let surname = document.querySelector("#surname")
        let licence = document.querySelector("#licence")

        const formData = {
            name: name.value,
            surname: surname.value,
            license: licence.value
        };

        const url = '/dentist/new';
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
                     '<strong></strong> Dentist created </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 console.log("Dentist created!")
                 resetUploadForm();

            })
            .catch(error => {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                    console.log("Error!")
                    document.querySelector('#response').innerHTML = errorAlert;
                    document.querySelector('#response').style.display = "block";
                    //se dejan todos los campos vacíos por si se quiere ingresar otro odontologo
                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#input-first-name').value = "";
        document.querySelector('#input-last-name').value = "";
        document.querySelector('#input-user-name').value = "";
        document.querySelector('#input-password').value = "";
        document.querySelector('#input-email').value = "";
        document.querySelector('#input-license').value = "";

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