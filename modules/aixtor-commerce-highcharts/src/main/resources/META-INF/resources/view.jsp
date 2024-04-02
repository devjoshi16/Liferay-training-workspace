<%@ include file="/init.jsp" %>

<!-- <figure class="highcharts-figure"> -->
<!-- <div class="row"> -->
<!-- 	<div class='col-md-6'> -->
<!-- 		<div id="bar-chart-container"></div> -->
<!-- 	</div> -->
<!-- 	<div class='col-md-6'> -->
<!-- 		<div id="pie-chart-container"></div> -->
<!-- 	</div> -->
<!-- </div> -->
<!-- </figure> -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://rawgit.com/mholt/PapaParse/master/papaparse.js"></script>

<div class="row">
	<div class='col-md-6'>
		<div class="container" id="container1"></div>
	</div>
	<div class='col-md-6'>
		<div class="container" id="container2"></div>
	</div>
</div>

<select name="select" id="select">
  <option value="Jan">January</option>
  <option value="Feb">February</option>
  <option value="Mar">March</option>
  <option value="Apr">April</option>
  <option value="May">May</option>
  <option value="Jun">June</option>
  <option value="Jul">July</option>
  <option value="Aug">August</option>
  <option value="Sep">September</option>
  <option value="Oct">October</option>
  <option value="Nov">November</option>
  <option value="Dec">December</option>
</select>

<pre id="data">Mini Dome Cameras,1,2,3,9,12,33,10,11,20,18,30,35,
PTZ IR Cameras,5,6,7,4,23,8,15,25,12,10,20,20,
Project Dome Cameras,7,8,9,2,21,14,20,10,25,5,11,10,
VMS,1,2,4,8,31,20,9,11,15,20,30,18,
Turrent Network Cameras,9,10,4,20,13,18,15,17,10,30,35,40</pre>

<script type="text/javascript">
var csv = Papa.parse(document.getElementById('data').innerHTML);

Highcharts.chart('container1', {
  xAxis: {
    type: 'category'
  },
  title: {
      text: 'Orders Per Month'
  },
  series: [{
    type: 'bar',
    name: 'People',
    data: [
      ['Oppo Reno 10', 35],
      ['PTZ IR Cameras', 45],
      ['Project Dome Cameras', 29],
      ['VMS', 19],
      ['Turrent Network Cameras', 9]
    ],
    keys: ['name', 'y']
  }],
});

Highcharts.chart('container2', {
  xAxis: {
    type: 'category'
  },
  title: {
      text: 'Orders By Product'
  },
  series: [{
    type: 'pie',
    name: 'People',
    data: [
      ['Mini Dome Cameras', 35],
      ['PTZ IR Cameras', 45],
      ['Project Dome Cameras', 29],
      ['VMS', 19],
      ['Turrent Network Cameras', 9]
    ],
    keys: ['name', 'y']
  }],
});

/* Highcharts.chart('container3', {
  xAxis: {
    type: 'category'
  },
  series: [{
    type: 'line',
    name: 'People',
    data: [
      ['Nick', 35],
      ['Ann', 45],
      ['Joe', 29]
    ],
    keys: ['name', 'y']
  }],
}); */


var select = document.getElementById('select');

select.addEventListener('change', (e) => {
  var month = e.target.value;
  var monthsArr = Highcharts.defaultOptions.lang.shortMonths;
  var monthIndex = monthsArr.indexOf(month) + 1;
  var data = [];

  for (var j = 0; j < csv.data.length; j++) {
    data.push([
      csv.data[j][0], +csv.data[j][monthIndex]
    ]);
  }

  Highcharts.charts.forEach((chart) => {
    chart.series[0].update({
      data: data
    }, false, false, false);

    chart.redraw();
  });
});

</script>

<!-- // 	$(document).ready(function() {
		
// 		var categories = ['Jan', 'Feb', 'March', 'April', 'May','June','July','Aug','Sep','Oct','Nov','Dec'];
// 		var data = [1318, 1073, 1060, 813, 775, 850, 900, 380, 1000, 690, 290, 500];
// 		//var color = ['#A13119', '#ff0000', '#A13119', '#A13119', '#A13119'];
// 		var seriesData = [
// 			{
// 				name: 'Jan',
// 				data: [1318],
// 				colorByPoint: true,
// 				color: '#A13119'
// 			}, {
// 				name: 'Feb',
// 				data: [1073],
// 				colorByPoint: true,
// 				color: '#ff0000'
// 			}, {
// 				name: 'March',
// 				data: [1060],
// 				colorByPoint: false
// 			}, {
// 				name: 'April',
// 				data: [813],
// 				colorByPoint: false
// 			}, {
// 				name: 'May',
// 				data: [775],
// 				colorByPoint: false
// 			},{
// 				name: 'June',
// 				data: [850],
// 				colorByPoint: false
// 			},{
// 				name: 'July',
// 				data: [900],
// 				colorByPoint: false
// 			},{
// 				name: 'Aug',
// 				data: [380],
 --><!-- // 				colorByPoint: false
// 			},{
// 				name: 'Sep',
// 				data: [1000],
// 				colorByPoint: false
// 			},{
// 				name: 'Oct',
// 				data: [690],
// 				colorByPoint: false
// 			},{
// 				name: 'Nov',
// 				data: [290],
// 				colorByPoint: false
// 			},{
// 				name: 'Dec',
// 				data: [500],
// 				colorByPoint: false
// 			}
// 		];

// 		var barChartOptions = {
// 			chart: {
// 				renderTo: 'bar-chart-container',
// 				type: 'column',
// 				options3d: {
// 					enabled: true,
// 					alpha: 0,
// 					beta: 0,
// 					depth: 50,
// 					viewDistance: 10
// 				}
// 			},
// 			xAxis: {
// 				categories: categories
// 			},
// 			yAxis: {
// 				title: {
// 					enabled: false
// 				}
// 			},
// 			tooltip: {
// 				headerFormat: '<b>{point.key}</b><br>',
// 				pointFormat: 'sold: {point.y}'
// 			},
// 			title: {
// 				text: 'Orders Per Month',
// 				align: 'left'
// 			},
// 			/* subtitle: {
// 				text: 'Source: ' +
// 					'<a href="http://localhost:8080/"' +
// 					'target="_blank">OFV</a>',
// 				align: 'left'
// 			}, */
// 			legend: {
// 				enabled: true,
// 				layout: 'vertical',
// 				align: 'right',
// 				verticalAlign: 'middle'
// 			},
// 			plotOptions: {
// 				column: {
// 					depth: 10,					 
// 				    pointWidth:20
// 				}
// 			},
// 			series: [{
// 				data: data,
// 				//colorByPoint: true,
// 				//color: color
// 			}],
// 			// series: seriesData,
// 			exporting: {
// 				showTable: false,
// 				tableCaption: 'Data table',
// 				menuItemDefinitions: {
// 					showDataTable: {
// 						onclick: function() {
// 							if (this.dataTableDiv && this.dataTableDiv.style.display !== 'none') {
// 								this.dataTableDiv.style.display = 'none';
// 							} else {
// 								this.viewData();
// 								this.dataTableDiv.style.display = '';
// 							}
// 						},
// 						text: 'Toggle Table'
// 					}
// 				},
// 				buttons: {
// 					contextButton: {
// 						menuItems: ['downloadPNG', 'downloadPDF', 'separator', 'downloadCSV', 'downloadXLS', 'separator', 'showDataTable']
// 					}
// 				}
// 			}
// 		};

// 		Highcharts.chart('bar-chart-container', barChartOptions);

// 		// PIE Chart Configurations......

// 		var pieChartTitle = 'Orders By Product';
// 		var pieData = [
// 			['Mini Dome Cameras', 55.0],
// 			['PTZ IR Cameras', 27.5],
// 			['Project Dome Cameras', 9.5],
// 			['VMS', 7.2],
// 			['Turrent Network Cameras', 1.5]
// 		];
// 		var pieSeriesData = [{
// 				name: 'Mini Dome Cameras',
// 				y: 20.0,
// 				sliced: true,
// 				selected: true,
// 				color: '#A13119'
// 			}, {
// 				name: 'PTZ IR Cameras',
// 				y: 20.0
// 			},  {
// 				name: 'Project Dome Cameras',
// 				y: 20.0
// 			}, {
// 				name: 'VMS',
// 				y: 20.0
// 			}, {
// 				name: 'Turrent Network Cameras',
// 				y: 20.0
// 			}
// 		];

// 		var pieChartOption = {
// 			chart: {
//                 type: 'pie',
//                 options3d: {
//                     enabled: true,
//                     alpha: 45,
//                     beta: 0
//                 },
// 				events: {
// 					click: function(e) {
// 						// alert("Clicked On PIE Chart");
// 						console.log("Click Function Invoked......");
// 						if (this.dataTableDiv && this.dataTableDiv.style.display !== 'none') {
// 							this.dataTableDiv.style.display = 'none';
// 						} else {
// 							this.viewData();
// 							this.dataTableDiv.style.display = '';
// 							var tableId = this.dataTableDiv.children[0].id;
// 							$("#" + tableId).DataTable({
// 								"bAutoWidth": false
// 							});
// 							// var tableEL = this.dataTableDiv.children("table");
// 							console.log("  -> Table Element : " + this.dataTableDiv.children[0]);
// 							console.log("  -> Table ID : " + tableId);
// 						}
// 					},
// 					// selection: function(e) {
// 					// 	alert("selection function called....");
// 					// }
// 				}
//             },
//             title: {
//                 text: pieChartTitle
//             },
//             accessibility: {
//                 point: {
//                     valueSuffix: '%'
//                 }
//             },
//             tooltip: {
//                 pointFormat: '{series.name}: {point.percentage:.1f}%'
//             },
//             plotOptions: {
//                 pie: {
//                     allowPointSelect: true,
//                     cursor: 'pointer',
//                     depth: 30,
//                     dataLabels: {
//                         enabled: true,
//                         format: '{point.name}'
//                     }
//                 },
// 				series: {
// 					point: {
// 						events: {
// 							click: function() {
// 								console.log("Click On Data.....");
// 							}
// 						}
// 					}
// 				}
//             },
//             // series: [{
//             //     type: 'pie',
//             //     name: 'Website used',
//             //     data: pieData
//             // }],
// 			series: [{
// 				name: 'Printers',
// 				colorByPoint: true,
// 				data: pieSeriesData
// 			}],
// 			exporting: {
// 				showTable: false,
// 				tableCaption: 'Data table',
// 				menuItemDefinitions: {
// 					showDataTable: {
// 						onclick: function() {
// 							if (this.dataTableDiv && this.dataTableDiv.style.display !== 'none') {
// 								this.dataTableDiv.style.display = 'none';
// 							} else {
// 								this.viewData();
// 								this.dataTableDiv.style.display = '';
// 							}
// 						},
// 						text: 'Toggle Table'
// 					}
// 				},
// 				buttons: {
// 					contextButton: {
// 						menuItems: ['downloadPDF', 'downloadCSV', 'downloadXLS', 'separator', 'viewData', 'separator', 'showDataTable']
// 					}
// 				}
// 			},
// 			credits: {
// 				enabled: false
// 			},
// 		};

// 		Highcharts.chart('pie-chart-container', pieChartOption);
		
// 		// area Chart Configurations......

		
// 	}); -->

