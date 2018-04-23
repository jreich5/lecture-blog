$(document).ready(function() {

    const buildHtml = (response) => {
        let output = "";
        response.forEach((ad) => {
            output += `<h3>${ad.title}</h3>`;
            output += `<p>${ad.description}</p>`;
            output += `<hr />`;
        });
        return output;
    };

    $.get("/ads.json").done(function(data) {
        console.log(data);
        $("#ads").html(buildHtml(data));

    });


});