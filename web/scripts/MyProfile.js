window.onload = function () {

    function MyProfileShow() {
        $('.field span').hide();
        $('.field input, .field select, .field .data').show();

        $('#btnEdit').addClass('btn-color-h37-inactive');

        $('#btnCancel').removeClass('btn-color-h37-inactive');
        $('#btnSave').removeClass('btn-color-h37-inactive');
        $(this).addClass('btn-color-h37-inactive');
    };

    function MyProfileHide() {
        $('.field span').show();
        $('.field input,  .field select, .field .data').hide();
        $('#btnCancel').removeClass('btn-color-h37-inactive');
        $('#btnEdit').addClass('btn btn-color-h37');

        $('#btnSave').addClass('btn-color-h37-inactive');
        $(this).addClass('btn-color-h37-inactive');

    };

    function editMyProfile() {
        $('.editProfile .field input, .editProfile .field select').hide();
        $('#btnEdit').click(function (event) {
            event.preventDefault();
            MyProfileShow();
        });

    $('#btnSave').click(function (event) {
        event.preventDefault();
        $('#btnSubmits').click();
        MyProfileHide();
        //obj.click();
    });
    };

    function startMyProfile() {
        editMyProfile();
    };


    $(document).ready(function () {
        // put all your jQuery goodness in here.
        editMyProfile();

    });

    Sys.WebForms.PageRequestManager.getInstance().add_endRequest(EndRequestHandler);
    function EndRequestHandler(sender, args) {
        if (args.get_error() == undefined) {
            startMyProfile();
        }
    }

}