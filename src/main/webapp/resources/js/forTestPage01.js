$(function () {
    setInterval(updateDataTable, 2000);
});

function updateDataTable() {
    $.ajax({
        url: "/rest/testInterval/all",
        type: "GET",
        success: function (data) {
            console.log(new Date($.now()) + ": testIntervalTable is updated !");
            testIntervalTableApi.clear().rows.add(data).draw();
        }

    });
}

var testIntervalTableApi = $("#testIntervalTable").DataTable({
    info: true,
    searching: true,
    paging: false,
    sort: true,
    columns: [
        {
            data: "id"
        },
        {
            data: "startI"
        },
        {
            data: "endI"
        }
    ]
});

function threadToDeleteRun() {
    $.post("/rest/addThreadDelete");
}

function threadToCreateRun() {
    $.post("/rest/addThreadCreate");
}