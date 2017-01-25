$('#clock').countdown('2017/10/28 16:00:00')
    .on('update.countdown', function (event) {
        var format = '<p>%H:%M:%S</p>';

        if (event.offset.totalDays > 1 || event.offset.totalDays == 0) {
            format = '%-d dni ' + format;
        } else {
            format = '%-d dzień ' + format;
        }

        if (event.offset.weeks > 5 || event.offset.weeks == 0) {
            format = '%-w tygodni ' + format;
        } else if (event.offset.weeks < 5 && event.offset.weeks < 1) {
            format = '%-w tygodnie ' + format;
        } else {
            format = '%-w tydzień ' + format;
        }

        $(this).html(event.strftime(format));
    });

$.validate({
    lang: 'pl',
    form : '#contact-form'
});