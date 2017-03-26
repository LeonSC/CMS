<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../static/header.jsp" %>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12">
			<div id="container" style="width:100%;height:500px"></div>
		</div>
	</div>
</div>
<%@ include file="../static/footer.jsp" %>
</body>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=OthmXfaHGFdfnobTQAuHIYWcunuQP8X1"></script>
<script type="text/javascript">
// 百度地图API功能
var map = new BMap.Map("container");    // 创建Map实例
map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);  // 初始化地图,设置中心点坐标和地图级别
map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
map.setCurrentCity("北京");          // 设置地图显示的城市 此项是必须设置的
map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

var local = new BMap.LocalSearch(map, {
	renderOptions:{map: map}
});
local.search("天安门");

map.addEventListener("click", function(e){
	var pt = e.point;
	alert(JSON.stringify(pt));
});
</script>
</html>