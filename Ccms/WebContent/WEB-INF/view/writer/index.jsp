<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../static/header.jsp" %>
<body onload="geocoder()">
<div class="container-fluid">
	<div class="row">
		<div class="col-xs-12" style="height:500px">
			<div id="container"></div>
			<div id="tip">
			    <span id="result"></span>
			</div>
		</div>
	</div>
</div>
<%@ include file="../static/footer.jsp" %>
</body>
<link rel="stylesheet" href="http://cache.amap.com/lbs/static/main1119.css"/>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=d50647cd9336a4e78521e23964fe3e1e&plugin=AMap.Geocoder"></script>
<script type="text/javascript" src="http://cache.amap.com/lbs/static/addToolbar.js"></script>
<script type="text/javascript">
var map = new AMap.Map("container", {resizeEnable: true});
//geocoder();
function geocoder() {
    var geocoder = new AMap.Geocoder({
        city: "010", //城市，默认：“全国”
        radius: 1000 //范围，默认：500
    });
    //地理编码,返回地理编码结果
    geocoder.getLocation("北京市海淀区苏州街", function(status, result) {
        if (status === 'complete' && result.info === 'OK') {
            geocoder_CallBack(result);
        }
    });
}
function addMarker(i, d) {
    var marker = new AMap.Marker({
        map: map,
        position: [ d.location.getLng(),  d.location.getLat()]
    });
    var infoWindow = new AMap.InfoWindow({
        content: d.formattedAddress,
        offset: {x: 0, y: -30}
    });
    marker.on("mouseover", function(e) {
        infoWindow.open(map, marker.getPosition());
    });
}
//地理编码返回结果展示
function geocoder_CallBack(data) {
    var resultStr = "";
    //地理编码结果数组
    var geocode = data.geocodes;
    for (var i = 0; i < geocode.length; i++) {
        //拼接输出html
        resultStr += "<span style=\"font-size: 12px;padding:0px 0 4px 2px; border-bottom:1px solid #C1FFC1;\">" + "<b>地址</b>：" + geocode[i].formattedAddress + "" + "&nbsp;&nbsp;<b>的地理编码结果是:</b><b>&nbsp;&nbsp;&nbsp;&nbsp;坐标</b>：" + geocode[i].location.getLng() + ", " + geocode[i].location.getLat() + "" + "<b>&nbsp;&nbsp;&nbsp;&nbsp;匹配级别</b>：" + geocode[i].level + "</span>";
        addMarker(i, geocode[i]);
    }
    map.setFitView();
    document.getElementById("result").innerHTML = resultStr;
}
</script>
</html>