<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thống kê dữ liệu</title>

</head>
<body>
<div class="main-content">
   	  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <div id="chart_div"style="width: 100%; height: 700px;"></div>
  	<script type="text/javascript">
  	google.charts.load('current', {packages: ['corechart', 'bar']});
  	google.charts.setOnLoadCallback(drawBasic);

  	function drawBasic() {

  	      var data = new google.visualization.DataTable();
  	      data.addColumn('string', 'time');        
  	      data.addColumn('number', 'Số người đặt mua');
  	      
  	      data.addRows([
  	    	<c:forEach var="item" items="${myItem.listResult}">
  	        	[{v: '${item.time}', f: '${item.time}'}, ${item.value}],
  	     	</c:forEach>
  	       /*  [{v: '9, 0, 0', f: '9 am'}, 2],
  	        [{v: '10, 0, 0', f:'10 am'}, 3],
  	        [{v: '11, 0, 0', f: '11 am'}, 4],
  	        [{v: '12, 0, 0', f: '12 pm'}, 5],
  	        [{v: '13, 0, 0', f: '1 pm'}, 6],
  	        [{v: '14, 0, 0', f: '2 pm'}, 7],
  	        [{v: '15, 0, 0', f: '3 pm'}, 8],
  	        [{v: '16, 0, 0', f: '4 pm'}, 9],
  	        [{v: '17, 0, 0', f: '5 pm'}, 10],  */
  	      ]);

  	      var options = {
  	        title: 'Thống kê dữ liệu trong 10 ngày gần nhất',
  	        hAxis: {
  	          title: '',
  	          format: 'd-M-yyyy',
  	          viewWindow: {
  	            min: [7, 30, 0],
  	            max: [17, 30, 0]
  	          }
  	        },
  	        vAxis: {
  	          title: 'Rating (scale of 1-10)'
  	        }
  	      };

  	      var chart = new google.visualization.ColumnChart(
  	        document.getElementById('chart_div'));

  	      chart.draw(data, options);
  	    }
  	</script>
  	</div>

<!-- <div class="span-2c">  
     <h3 class="tlt">Bar Chart</h3>
     <canvas id="bar" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
     <script>
           var barChartData = {
                labels: [<c:forEach var="item" items="${myItem.listResult}">'${item.time}',</c:forEach>],
                datasets: [
                     {
                          fillColor: "#FC8213",
                          data: [<c:forEach var="item" items="${myItem.listResult}">,</c:forEach>]
                     }
                ]
           };
           new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
     </script>
</div> -->
</body>
</html>