
/*	$.post("pie/list", function(data){
		console.info(data);
	});*/
$(function () {
	chart = new Highcharts.Chart({
        chart: {
        	renderTo: 'container',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: '用户分布地区饼状图'
        },
        tooltip: {
            headerFormat: '{series.name}<br>',
            pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true
                },
                showInLegend: true
            }
        },
        series: [{
            type: 'pie',
            name: '地区分布占比',
            data: [
                ['湖南省',   45.0],
                ['江苏省',       26.8],
                {
                    name: '河南省',
                    y: 12.8,
                    sliced: true,
                    selected: true
                },
                ['安徽省',    8.5],
                ['湖北省',     6.2],
                ['其他',   0.7]
            ]
        }]
    });
});
