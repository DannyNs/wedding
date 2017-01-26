$('#clock').countdown('2017/10/28 16:00:00')
    .on('update.countdown', function (event) {
        var format = '<p>%H:%M:%S</p>';

        if (event.offset.totalDays > 1 || event.offset.totalDays == 0) {
            format = '%-D dni ' + format;
        } else {
            format = '%-D dzień ' + format;
        }

        $(this).html(event.strftime(format));
    });

$.validate({
    lang: 'pl',
    form : '#contact-form'
});