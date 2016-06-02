<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ page import="dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" class="g_html">

<head>

<title>书程小驿-购物车界面</title>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Cache-Control" content="no-transform" />
<meta name="renderer" content="webkit">
<link rel='canonical' href='http://www.xiaoxiaoye23.icoc.in/signup.jsp'>
<link type="text/css" href="http://0.ss.faisys.com/css/base.min.css?v=201603301453" rel="stylesheet" />
<link type="text/css" href="http://0.ss.faisys.com/css/template/4002.min.css?v=201602221737" rel="stylesheet" id="templateFrame"  class="templateFrameClass"/>
<link type="text/css" href="http://0.ss.faisys.com/css/bannerAnimation.min.css?v=201509241714" rel="stylesheet" />
	<link type='text/css' href='http://0.ss.faisys.com/css/searchBoxStyle1.min.css?v=201512141713' rel='stylesheet'>
	
<meta name="keywords" content=""/>
<meta name="description" content=""/>

<style id='stylemodule'>
#module310 .contentLineIcon {*padding:0;}
#module310 .contentLineIcon {*width:0;}
#module7 .contentLineIcon {*padding:0;}
#module7 .contentLineIcon {*width:0;}
#module7 .formMiddle7 a{text-decoration:underline;}
#module7 .formMiddle7 a{font-family:SimSun;}
#module7 .formMiddle7 a{font-weight:normal;}
#module7 .formMiddle7 a{font-size:12px;}
#module311 .contentLineIcon {*padding:0;}
#module311 .contentLineIcon {*width:0;}
#module27 .contentLineIcon {*padding:0;}
#module27 .contentLineIcon {*width:0;}
#module312 {height:46px;}
#module312 {border:none;}
#module312 {padding:0px;}
#module312 .formMiddle312{border:none;}
#module312 .formMiddle312{padding:0px;}
#module312 .formMiddle312 .formMiddleCenter312{border:none;}
#module312 .formMiddle312 .formMiddleCenter312{padding:0px;}
#module312 .formTop312{display:none;}
#module312 .formBottom312{display:none;}
#module312 .formMiddle312 .formMiddleLeft312{display:none;}
#module312 .formMiddle312 .formMiddleRight312{display:none;}
#module312 .formBanner312{display:none;}
#module312 .contentLineIcon {*padding:0;}
#module312 .contentLineIcon {*width:0;}
#module312 {background:none;}
#module312 .formMiddle312 {background:none;}
#module312 .formMiddle312 .formMiddleCenter312{background:none;}
#module312 .formMiddleContent312{background:none;}
#module344 {border:none;}
#module344 {padding:0px;}
#module344 .formMiddle344{border:none;}
#module344 .formMiddle344{padding:0px;}
#module344 .formMiddle344 .formMiddleCenter344{border:none;}
#module344 .formMiddle344 .formMiddleCenter344{padding:0px;}
#module344 .formTop344{display:none;}
#module344 .formBottom344{display:none;}
#module344 .formMiddle344 .formMiddleLeft344{display:none;}
#module344 .formMiddle344 .formMiddleRight344{display:none;}
#module344 .formBanner344{display:none;}
#module344 .contentLineIcon {*padding:0;}
#module344 .contentLineIcon {*width:0;}
#module344 {background:none;}
#module344 .formMiddle344 {background:none;}
#module344 .formMiddle344 .formMiddleCenter344{background:none;}
#module344 .formMiddleContent344{background:none;}
</style>
<style id='styleHeaderTop' type='text/css'>
</style>
<style id='stylefooter' type='text/css'>
</style>
<style id='styleWebSite' type='text/css'>
</style>
<style id='stylenav' type='text/css'>
#nav {height:48px;}
#nav {background-size: contain;}
#nav .navMainContent{height:100%;}
#nav  .navCenterContent{height:100%;}
#nav .navContent{height:48px;}
#nav  .navCenterContent{height:100%;}
#nav .navContent{background-size: contain;}
#nav  .navLeft{background-size: 100% 100%;}
#nav  .navRight{background-size: 100% 100%;}
#nav  .navCenterContent{background-size: contain;}
#nav {top:38px;}
#nav {left:299px;}
#nav .item{height:48px;}
#nav .item a{margin-top:0; margin-bottom:0; padding-top:0; padding-bottom:0;}
#nav .itemSep{background-position:center;}
#nav .itemSep{height:48px;}



<!--  表单样式*/  -->


.td1{
	font-family:"宋体";
	font-size:20px;
	padding:3px;
	text-align:center;
	letter-space:3px;
	width:32%;
	border-top-width:5px;
	border-bottom-width:1px;
	border-left-width:1px;
	border-right-width:1px;
	border-bottom-style:none;
	border-bottom-color:#099;
	border-top-style:double;
	border-top-color:#099;
	border-left-style:solid;
	border-left-color:#099;
	border-right-style:none;
	border-right-color:#099;
	}
.td2{
	font-family:"宋体";
	font-size:20px;
	padding:3px;
	text-align:center;
	letter-space:3px;
	width:32%;
	border-top-width:1px;
	border-bottom-width:1px;
	border-left-width:1px;
	border-right-width:1px;
	border-bottom-style:none;
	border-bottom-color:#099;
	border-top-style:solid;
	border-top-color:#099;
	border-left-style:solid;
	border-left-color:#099;
	border-right-style:none;
	border-right-color:#099;
	}
.td3{
	font-family:"宋体";
	font-size:20px;
	padding:3px;
	text-align:center;
	letter-space:3px;
	width:32%;
	border-top-width:1px;
	border-bottom-width:1px;
	border-left-width:1px;
	border-right-width:1px;
	border-bottom-style:solid;
	border-bottom-color:#099;
	border-top-style:solid;
	border-top-color:#099;
	border-left-style:solid;
	border-left-color:#099;
	border-right-style:solid;
	border-right-color:#099;
	}
.td4{
	font-family:"宋体";
	font-size:20px;
	padding:3px;
	text-align:center;
	letter-space:3px;
	width:32%;
	border-top-width:5px;
	border-bottom-width:1px;
	border-left-width:1px;
	border-right-width:1px;
	border-bottom-style:none;
	border-bottom-color:#099;
	border-top-style:double;
	border-top-color:#099;
	border-left-style:dotted;
	border-left-color:#099;
	border-right-style:solid;
	border-right-color:#099;
	}
.td5{
	font-family:"宋体";
	font-size:20px;
	padding:3px;
	text-align:center;
	letter-space:3px;
	width:32%;
	border-top-width:1px;
	border-bottom-width:1px;
	border-left-width:1px;
	border-right-width:1px;
	border-bottom-style:none;
	border-bottom-color:#099;
	border-top-style:solid;
	border-top-color:#099;
	border-left-style:dotted;
	border-left-color:#099;
	border-right-style:solid;
	border-right-color:#099;
	}
.td6{
	font-family:"宋体";
	font-size:20px;
	padding:3px;
	text-align:center;
	letter-space:3px;
	width:32%;
	border-top-width:5px;
	border-bottom-width:1px;
	border-left-width:1px;
	border-right-width:1px;
	border-bottom-style:none;
	border-bottom-color:#099;
	border-top-style:double;
	border-top-color:#099;
	border-left-style:solid;
	border-left-color:#099;
	border-right-style:solid;
	border-right-color:#099;
	}
.td7{
	font-family:"宋体";
	font-size:20px;
	padding:3px;
	text-align:center;
	letter-space:3px;
	width:32%;
	border-top-width:5px;
	border-bottom-width:1px;
	border-left-width:1px;
	border-right-width:1px;
	border-bottom-style:none;
	border-bottom-color:#099;
	border-top-style:double;
	border-top-color:#099;
	border-left-style:dotted;
	border-left-color:#099;
	border-right-style:none;
	border-right-color:#099;
	}
.td8{
	font-family:"宋体";
	font-size:20px;
	padding:3px;
	text-align:center;
	letter-space:3px;
	width:32%;
	border-top-width:1px;
	border-bottom-width:1px;
	border-left-width:1px;
	border-right-width:1px;
	border-bottom-style:none;
	border-bottom-color:#099;
	border-top-style:solid;
	border-top-color:#099;
	border-left-style:dotted;
	border-left-color:#099;
	border-right-style:none;
	border-right-color:#099;
	}
.chk_2{
	display:none;
	}
.chk_2 + label {
	background-color: #FFF;
	padding: 1px 1px 1px 1px;
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.05), inset 0px -15px 10px -12px rgba(0, 0, 0, 0.05);
	border-radius: 5px;
	display: inline-block;
	position: relative;
	border: 1px solid #099;
	margin-right: 30px;
	color:#000;
	font-size: 1em;
	height:30px;
	width: 100px;
	text-align:center;
	text-shadow: 0 1px 0 rgba(0, 0, 0, 0.2);
}
.chk_2 + label:hover  {
	border-top: 1px solid #099;
	backgroun:#0FC;
	box-shadow: inset 0 -50px 37px -30px rgba(255, 222, 197, 0.07), 0 0 13px rgba(0, 0, 0, 0.6);
}
</style>
</head>
<body class="g_body g_locale2052 " >
<div id="memberBarArea" class="memberBarArea g_editPanel">
	<div id="arrow" class="g_arrow g_arrow_up"></div>
	<div id="memberBar" class="memberBar">
	
<!--  right end*/  -->

	<div class='left'>
			<div style="float:left;margin-left: 8px;">
				<a id="topBarMember_addBookMark" hidefocus='true' href='javascript:;' style="text-decoration:none;display:none;" onclick="Fai.addBookmark(top.document.title, 'http://www.xiaoxiaoye23.icoc.in');">收藏本站</a>
			</div>	
			<div id="line1" class="line" style="float:left;display:none;"></div>
			<div style="float:left;">
				<a  id="topBarMember_myProfile" hidefocus="true" style="text-decoration:none;display:none;"  href="file:///E|/qq/2467865918/FileRecv/mCenter.jsp">我的资料</a>
			</div>	
	
			<div id="line2" class="line" style="float:left;display:none;"></div>
			<div style="float:left;">
				<a id="topBarMember_myOrder" hidefocus="true" style="text-decoration:none;display:none;" href="file:///E|/qq/2467865918/FileRecv/mCenter.jsp?item=memberOrder">我的订单</a>
			</div>
	
			<div style="float:left;  margin-left: 15px;">
				<div id="mobiWeb_js" class="mobiWeb" style="display:none;">
					<div class="mobiWebItem">
						<span class="mobiWeb_icon">&nbsp;</span>
						<span class="mobi_down">&nbsp;</span>
					</div>
				</div>
				<div class="mobiWebPanel" style="display:none;">
					<div id="mobiWebQRCode_js" class="mobiWebQRCode">
						<div style='text-align:center;padding-top:10px;'><img src='/qrCode.jsp?cmd=mobiQR&_s=80'></div>
						<div style='text-align:center;padding-top:2px;'>查看手机网站</div>
					</div>
				</div>
			</div>	 
	</div>
		<div id="topBarMsg" style="display:none; position:absolute; top:0; left:0; width:100%; height:100%; background:#eee; text-align:center; z-index: 9010;"></div>
	</div>
</div>

	<div id="g_main" class='g_main g_col17 ' style='top:35px' >
	<div id="web" class="g_web ">
		<table class="webTopTable" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					<div id="webTop" class="webTop">
						<div id='corpTitle' class='corpTitle corpTitle2' fontPatternTitle='true' style='top:50px;left:-53px;;'  _linkType='0' >	<div id='primaryTitle' style=' font-size:26px;font-weight: bolder;pointer-events:none;'>书程小驿</div>		<div id='subTitle' style='font-size:26px;font-weight:bolder;'>二手书、教材交易交换平台</div>	</div><div id='logo' class='logo logo2' style='top:45px;left:-127px;'><a id='logoLink' hidefocus='true' class='link-p' link='javascript:;' onclick='return false;'><img id='logoImg' title='xiaoxiaoye23' alt='xiaoxiaoye23' style='float:left;' height='75'width='71' src='http://8619014.s21i-8.faiusr.com/4/ABUIABAEGAAg6YD5tgUo45zV6gMw_Q44-g4!100x100.png' /></a></div>
					</div>
				</td>
			</tr>
		</table>
		<table class="absTopTable" cellpadding="0" cellspacing="0">
		<tr>
				<td align="center">
					<div id="absTopForms" class="forms sideForms absForms">
						<div style="position:absolute;"></div><!-- for ie6 -->
						<div id='module312' _indexClass='formIndex1' class='form  formIndex1 formStyle62' title='' style='position:absolute;top:61px;left:839px;width:314px;' _side='0' _inTab='0' _inMulMCol='0' _inFullmeasure='0' _autoHeight='0' _global='true' _independent='false' >
<table class='formTop formTop312' cellpadding='0' cellspacing='0'><tr><td class='left'></td><td class='center'></td><td class='right'></td></tr></table>
<table class='formMiddle formMiddle312' style='height:46px; ' cellpadding='0' cellspacing='0'><tr>
<td class='formMiddleLeft formMiddleLeft312'></td>
<td class='formMiddleCenter formMiddleCenter312' valign='top'>
<div class='formMiddleContent formMiddleContent312  '>
<div class='searchBox searchBoxStyle44'><div class='searchBoxContainer'><input class='g_itext'  placeholder='' value='' _nSL='[]' maxlength='100' /><a class='g_btn searchBoxBtn' href='javascript:;' onclick='Site.searchInSite(312);return false;'><span>搜索</span></a></div></div>
<div class='recommandKeyBox'><div class='linkKeys'><a class='recommandKey' href='javascript:;' onclick='Site.searchInSiteByKey(312,"");return false;'><span></span></a></div></div>
</div>
</td>
<td class='formMiddleRight formMiddleRight312'></td>
</tr></table>
<table class='formBottom formBottom312' cellpadding='0' cellspacing='0'><tr><td class='left left312'></td><td class='center center312'></td><td class='right right312'></td></tr></table>
<div class='clearfloat clearfloat312'></div>
</div>
<div id='module344' _indexClass='formIndex2' class='form  formIndex2 formStyle65' title='' style='position:absolute;top:-17px;left:1007px;width:140px;' _side='0' _inTab='0' _inMulMCol='0' _inFullmeasure='0' _autoHeight='1' _global='true' _independent='false' >
<table class='formTop formTop344' cellpadding='0' cellspacing='0'><tr><td class='left'></td><td class='center'></td><td class='right'></td></tr></table>
<table class='formMiddle formMiddle344' style='' cellpadding='0' cellspacing='0'><tr>
<td class='formMiddleLeft formMiddleLeft344'></td>
<td class='formMiddleCenter formMiddleCenter344' valign='top'>
<div class='formMiddleContent formMiddleContent344  '>
</div>
</td>
<td class='formMiddleRight formMiddleRight344'></td>
</tr></table>
<table class='formBottom formBottom344' cellpadding='0' cellspacing='0'><tr><td class='left left344'></td><td class='center center344'></td><td class='right right344'></td></tr></table>
<div class='clearfloat clearfloat344'></div>
</div>
					</div>
				</td>
			</tr>
		</table>
		<table class="webNavTable" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					<div id="webNav" class="webNav webNavDefault">
						<div id='nav' class='nav nav2 fixedNavPos '>
<div class='navMainContent'><table class='navTop' cellpadding='0' cellspacing='0'><tr><td class='navTopLeft'></td><td class='navTopCenter'></td><td class='navTopRight'></td></tr></table>
<table class='navContent' cellpadding='0' cellspacing='0'>
<tr>
<td class='navLeft'></td>
<td class='navCenterContent' id='navCenterContent' valign='top' align='left'>
<div id='navCenter' class='navCenter' style='width:480px;'>
<div class='itemPrev'></div>
<div class='itemContainer'>
<table title='' class='item itemCol2 itemIndex1' cellpadding='0' cellspacing='0' colId='2' id='nav2' onclick='window.open("/", "_self")'  _jump='window.open("/", "_self")' >
<tr>
<td class='itemLeft'></td>
<td class='itemCenter'><a hidefocus='true' style='outline:none;' href='/' target='_self' onclick='return false;'><span class='itemName0'>首页</span></a></td>
<td class='itemRight'></td>
</tr>
</table>
<div class='itemSep'></div><table title='' class='item itemCol21 itemIndex2' cellpadding='0' cellspacing='0' colId='21' id='nav21' onclick='window.open("/nr.jsp", "_self")'  _jump='window.open("/nr.jsp", "_self")' >
<tr>
<td class='itemLeft'></td>
<td class='itemCenter'><a hidefocus='true' style='outline:none;' href='/nr.jsp' target='_self' onclick='return false;'><span class='itemName0'>易书区</span></a></td>
<td class='itemRight'></td>
</tr>
</table>
<div class='itemSep'></div><table title='' class='item itemCol106 itemIndex3' cellpadding='0' cellspacing='0' colId='106' id='nav106' onclick='window.open("/col.jsp?id=106", "_self")'  _jump='window.open("/col.jsp?id=106", "_self")' >
<tr>
<td class='itemLeft'></td>
<td class='itemCenter'><a hidefocus='true' style='outline:none;' href='/col.jsp?id=106' target='_self' onclick='return false;'><span class='itemName0'>我的闲置</span></a></td>
<td class='itemRight'></td>
</tr>
</table>
<div class='itemSep'></div><table title='' class='item itemCol103 itemIndex4' cellpadding='0' cellspacing='0' colId='103' id='nav103' onclick='window.open("/col.jsp?id=103", "_self")'  _jump='window.open("/col.jsp?id=103", "_self")' >
<tr>
<td class='itemLeft'></td>
<td class='itemCenter'><a hidefocus='true' style='outline:none;' href='/col.jsp?id=103' target='_self' onclick='return false;'><span class='itemName0'>个人中心</span></a></td>
<td class='itemRight'></td>
</tr>
</table>
<div class='itemSep'></div><table title='' class='item itemCol5 itemIndex5' cellpadding='0' cellspacing='0' colId='5' id='nav5' onclick='window.open("/about.jsp", "_self")'  _jump='window.open("/about.jsp", "_self")' >
<tr>
<td class='itemLeft'></td>
<td class='itemCenter'><a hidefocus='true' style='outline:none;' href='/about.jsp' target='_self' onclick='return false;'><span class='itemName0'>关于我们</span></a></td>
<td class='itemRight'></td>
</tr>
</table>
</div>
<div class='itemNext'></div>
</div>
</td>
<td class='navRight'></td>
</tr>
</table>
<table class='navBottom' cellpadding='0' cellspacing='0'><tr><td class='navBottomLeft'></td><td class='navBottomCenter'></td><td class='navBottomRight'></td></tr></table>
</div>
</div>
<a href='/col.jsp?id=105' style='display:none;'>发布闲置</a><a href='/mcart.jsp' style='display:none;'>购物车</a><a href='/contact.jsp' style='display:none;'>联系我们</a><a href='/msgBoard.jsp' style='display:none;'>留言板</a>
					</div>
				</td>
			</tr>
		</table>
		<table class="webHeaderTable" cellpadding="0" cellspacing="0" id="webHeaderTable">
			<tr>
				<td align="center" class="webHeaderTd">
					<div id="webHeader" class="webHeader">
						<table class='headerTable' cellpadding='0' cellspacing='0'>
							<tr>
								<td class='headerCusLeft'></td>
								<td class='headerCusMiddle' align='center' valign='top'>
									<div class='headerNav'>
								
									</div>
								</td>
								<td class='headerCusRight'></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<table class="webBannerTable" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					<div id="webBanner" class="webBanner">
						<table class="bannerTable" cellpadding="0" cellspacing="0">
							<tr>
								<td class="bannerLeft"></td>
								<td class="bannerCenter" align='center' valign='top'>
									<div class='bannerTop'></div>
<div id='banner' class='banner extBanner' style='background:url(http://8619014.s21i-8.faiusr.com/2/ABUIABACGAAgg4P6tgUo2I-oDjCgCzj8Ag.jpg) 50% 50% no-repeat;height:380px'  normalheight='380' defaultwidth='0'>
	<div class='banner defaultBannerMain' style='background:url(http://8619014.s21i-8.faiusr.com/2/ABUIABACGAAgg4P6tgUo2I-oDjCgCzj8Ag.jpg) 50% 50% no-repeat;height:380px'></div>
	<div class='defaultBannerEdge defaultBannerEdgeRight'></div>
	<div class='defaultBannerEdge defaultBannerEdgeLeft'></div>
</div>

								</td>
								<td class="bannerRight"></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>

		<table class="absMiddleTable" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					<div id="absForms" class="forms sideForms absForms">
						
					</div>
				</td>
			</tr>
		</table>
		
		<div id="fullmeasureTopForms" class="fullmeasureContainer forms sideForms fullmeasureForms fullmeasureTopForms" style='display:none'>
			
		<wbr style='display:none;' /></div>
		
		<table id="webContainerTable" class="webContainerTable" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center">
					<div id="webContainer" class="webContainer">
						<div id="container" class="container">
	<table class="containerTop" cellpadding='0' cellspacing='0'>
		<tr valign='top'>
			<td class="left"></td>
			<td class="center"></td>
			<td class="right"></td>
		</tr>
	</table>

	<table class="containerMiddle" cellpadding='0' cellspacing='0'>
		<tr valign='top'>
			<td id="containerMiddleLeft" class="containerMiddleLeft">
			</td>

			<td class="containerMiddleCenter">
				<div id="containerMiddleCenterTop" class="containerMiddleCenterTop">
					
				</div>

				<div id="containerForms" class="containerForms">
					<div id="topForms" class="column forms mainForms topForms" style='display:none'>
						
					</div>

					<table class="containerFormsMiddle" cellpadding='0' cellspacing='0'>
						<tr>
							<td valign="top" id="containerFormsLeft" class="containerFormsLeft" >
								<div class="containerFormsLeftTop">
								</div>
								<div id="leftForms" class="column forms sideForms leftForms">
								
<table class='formTop formTop310' cellpadding='0' cellspacing='0'><tr><td class='left'></td><td class='center'></td><td class='right'></td></tr></table>
<table class='formBanner formBanner310' cellpadding='0' cellspacing='0'><tr>
<td class='left left310'></td>
<td class='center center310' valign='top'>
<table cellpadding='0' cellspacing='0' class='formBannerTitle formBannerTitle310'><tr>
<td class='titleLeft titleLeft310' valign='top'>
</td>
<td class='formMiddleRight formMiddleRight310'></td>
</tr></table>
<table class='formBottom formBottom310' cellpadding='0' cellspacing='0'><tr><td class='left left310'></td><td class='center center310'></td><td class='right right310'></td></tr></table>
<div class='clearfloat clearfloat310'></div>

<table class='formTop formTop7' cellpadding='0' cellspacing='0'><tr><td class='left'></td><td class='center'></td><td class='right'></td></tr></table>
<tr>
<td class='left left7'></td>
<td class='center center7' valign='top'>
<table class='formBottom formBottom7' cellpadding='0' cellspacing='0'><tr><td class='left left7'></td><td class='center center7'></td><td class='right right7'></td></tr></table>
<div class='clearfloat clearfloat7'></div>
<table class='formBanner formBanner311' cellpadding='0' cellspacing='0'><tr>
<td class='left left311'></td>
<td class='center center311' valign='top'>
<table cellpadding='0' cellspacing='0' class='formBannerTitle formBannerTitle311'><tr>
<td class='titleCenter titleCenter311' valign='top'>
<td class='titleCenter titleCenter27' valign='top'>
<div class='titleText titleText27'><h3>购物车商品</h3>
</td>
<td class='titleRight titleRight27' valign='top'>
</td>
</tr></table>
</td>
<td class='right right27'></td>
</tr></table>
<table class='formMiddle formMiddle27' style='' cellpadding='0' cellspacing='0'><tr>
<td class='formMiddleLeft formMiddleLeft27'></td>
<td class='formMiddleCenter formMiddleCenter27' valign='top'>
<div class='formMiddleContent formMiddleContent27  '>
<table class='memberSignupMsg g_tip' cellpadding='0' cellspacing='0'>
<tr>
<td class='msgItem'></td>
<td class='msgText'></td>
</tr>
    
     <form action="product?product=toOrder" method="post">
        <table cellpadding="10" cellspacing="0">

            <%
            	HttpSession sessionCart=request.getSession();
            	shoppingCart sc=(shoppingCart)sessionCart.getAttribute("cart");
            	
            	//System.out.println("购物车主人"+sc.getUser().getName());
            	out.println("<tr><td class=td7>"+sc.getUser().getName()+"的购物车</td> <td></td> <td> </td><td> </td></tr>");
            	out.println("<tr><td class="+"td7"+">书籍</td><td class="+"td7"+ ">价格</td><td class=" +"td7"+">购买量</td><td class="+"td7"+">总价格</td><td class="+"td4"+"></td></tr>");
            	for(int i=0;i<sc.getBookInfos().size();i++){
            		out.println("<tr><td class="+ "td2" +">"+sc.getBookInfos().get(i).getBook().getName()+"</td><td class="+"td8"+">"+sc.getBookInfos().get(i).getBook().getPrice()+"</td> <td class="+"td8"+">"+sc.getBookInfos().get(i).getQuantities()+"</td><td class="+"td8"+">"+sc.getBookInfos().get(i).getQuantities()*sc.getBookInfos().get(i).getBook().getPrice()+"</td><td class="+"td5"+"><input type='checkbox' name='book' value="+sc.getBookInfos().get(i).getBook().getId()+" /></td></tr>");
            	}
            	//<td calss=td5><button onClick=deletePurInfo('${"+sc.getBookInfos().get(i).getBook().getId()+"}') type='submit' >删除</button></td>
            %>
            <tr><td  colspan="5" class="td3"><input type='submit' value='生成订单'id="checkbox2" class="chk_2"><label for="checkbox2">生成订单</label></td></tr>

    </form>

    </script>
	<table id="webFooterTable" class="webFooterTable" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center" valign="top">
					<div id="footerResizeWarp" class="footerResizeWarp">				
						<div id="webFooter" class="webFooter">
		
<div id="footer" class="footer" >
	<table class="footerTop" cellpadding="0" cellspacing="0">
	</table>
	<table class="footerMiddle" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td class="middleLeft"></td>
			<td class="middleCenter" align="center">
				<div class="footerContent">
			<div id='footerNav' class='footerNav  footerPattern1' cusheight='0'>
				<div class='footerItemListBox'>
					<ul class='footerItemListContainer'>
				<li class='footerItemSection'>
				  <div class='footerVerticalLine'>
				    <div class='footerVerticalLine'></div>
				  </div></li></ul></div>
</div>

					<div class="footerInfo">
						<p><span style="line-height:2;font-family:SimSun;"><span style="background-color:#FFFFFF;"></span></span></p><ul style="margin:4px 0px 0px;padding:0px;text-align:center;list-style-type:none;"><p align="left"><strong><span style="font-weight:normal;"><strong><span>长沙市书程小驿有限责任公司</span></strong></span></strong></p></ul><ul style="margin:4px 0px 0px;padding:0px;text-align:center;list-style-type:none;"><span style="font-weight:bold;"><span style="font-weight:normal;"><strong><span style="font-size:19px;"><span style="line-height:21px;font-size:12px;font-weight:normal;"></span></span></strong></span></span><ul style="margin:4px 0px 0px;padding:0px;text-align:center;list-style-type:none;"><p align="left"><span style="font-family:SimSun;">地址：<strong><span style="font-size:11px;">长沙市岳麓区湖南大学天马学生公寓</span></strong> 邮编：410000</span></p></ul></ul><div align="left"><br /></div>
					</div>				
				</div>
			</td>
			<td class="middleRight"></td>
		</tr>
	</table>
	<table class="footerBottom" cellpadding='0' cellspacing='0'>
		<tr valign='top'>
			<td class="bottomLeft"></td>
			<td class="bottomCenter"></td>
			<td class="bottomRight"></td>
		</tr>
	</table>	
</div>				
				</div>
					</div>
				</td>
			</tr>
		</table>
		<div class="clearfloat"></div>

</body>
</html>