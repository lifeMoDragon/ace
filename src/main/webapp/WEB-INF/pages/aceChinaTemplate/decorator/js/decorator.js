/**
 * 控制台菜单
 */
$(function (){
	initDecoratorPage();
})

//框架初始化
function initDecoratorPage(){
	initUnCompleteTaskMsg();
	initNotificationsMsg();
	initMessagesMsg();
}

//初始化未完成任务信息
function initUnCompleteTaskMsg(){
	//未完成任务数量
	$("#unCompleteTaskNumber").html(4);
	//未完成任务提示信息
	$("#unCompleteTaskTitle").text('4个待完成任务');
	//未完成任务列表
	var listMap = new Array();
	var map = {};
	map['taskName'] = '软件更新';
	map['progress'] = '65';
	map['url'] = '#';
	map['progressType'] = '';
	listMap[0] = map;
	map = {};
	map['taskName'] = '硬件升级';
	map['progress'] = '35';
	map['url'] = '#';
	map['progressType'] = 'progress-bar-danger';
	listMap[1] = map;
	map = {};
	map['taskName'] = '单元测试';
	map['progress'] = '15';
	map['url'] = '#';
	map['progressType'] = 'progress-bar-warning';
	listMap[2] = map;
	map = {};
	map['taskName'] = '漏洞修复';
	map['progress'] = '90';
	map['url'] = '#';
	map['progressType'] = 'progress-bar-success';
	listMap[3] = map;
	var html = '';
	for(var i = 0;i < listMap.length; i++){
		html += '<li>'
			+ '<a href="'+listMap[i]['url']+'">'
			+ '<div class="clearfix">'
			+ '<span class="pull-left">'+listMap[i]['taskName']+'</span>'
			+ '<span class="pull-right">'+listMap[i]['progress']+'%</span>'
			+ '</div>'
			+ '<div class="progress progress-mini progress-striped active">'
			+ '<div style="width:'+listMap[i]['progress']+'%" class="progress-bar '+listMap[i]['progressType']+'"></div>'
			+ '</div>'
			+ '</a>'
			+ '</li>';
	}
	$("#unCompleteTaskList").html(html);
}

//初始化通知信息
function initNotificationsMsg(){
	//通知数量
	$("#notificationNumber").html(8);
	//通知提示信息
	$("#notificationTitle").text('8个通知');
	setNotificationList('comment',null,12);//评论通知
	setNotificationList('group','Bob刚刚注册成为编辑...',null);//组织通知
	setNotificationList('order',null,8);//订单通知
	setNotificationList('follower',null,11);//粉丝通知
}
//通知设置
function setNotificationList(type,title,number){
	if(title != null && $.trim(title) != ''){
		$("#"+type+"Notification").children("span").eq(0).find("span").text(title);
	}
	if(number != null && $.trim(number) != ''){
		$("#"+type+"Notification").children("span").eq(1).text('+'+number);
	}
}
//初始化邮件信息列表
function initMessagesMsg(){
	//邮件数量
	$("#messageNumber").text(5);
	//邮件提示信息
	$("#messageTitle").text('5封邮件');
	var listMap = new Array();
	var map = {};
	map['imgUrl'] = basePath+'/pages/assets/images/avatars/avatar.png';
	map['imgAlt'] = 'Alex\'s Avatar';
	map['userName'] = 'Alex';
	map['url'] = '#';
	map['msgDetail'] = 'Ciao sociis natoque penatibus et auctor ...';
	map['msgTime'] = '刚刚';
	listMap[0] = map;
	map = {};
	map['imgUrl'] = basePath+'/pages/assets/images/avatars/avatar3.png';
	map['imgAlt'] = 'Susan\'s Avatar';
	map['userName'] = 'Susan';
	map['url'] = '#';
	map['msgDetail'] = 'Vestibulum id ligula porta felis euismod ...';
	map['msgTime'] = '20分钟前';
	listMap[1] = map;
	map = {};
	map['imgUrl'] = basePath+'/pages/assets/images/avatars/avatar4.png';
	map['imgAlt'] = 'Bob\'s Avatar';
	map['userName'] = 'Bob';
	map['url'] = '#';
	map['msgDetail'] = 'Nullam quis risus eget urna mollis ornare ...';
	map['msgTime'] = '3:15 pm';
	listMap[2] = map;
	map = {};
	map['imgUrl'] = basePath+'/pages/assets/images/avatars/avatar2.png';
	map['imgAlt'] = 'Kate\'s Avatar';
	map['userName'] = 'Kate';
	map['url'] = '#';
	map['msgDetail'] = 'Ciao sociis natoque eget urna mollis ornare ...';
	map['msgTime'] = '1:33 pm';
	listMap[3] = map;
	map = {};
	map['imgUrl'] = basePath+'/pages/assets/images/avatars/avatar5.png';
	map['imgAlt'] = 'Fred\'s Avatar';
	map['userName'] = 'Fred';
	map['url'] = '#';
	map['msgDetail'] = 'Vestibulum id penatibus et auctor  ...';
	map['msgTime'] = '10:09 am';
	listMap[4] = map;
	var html = '';
	for(var i=0;i<listMap.length;i++){
		html += '<li>'
			+ '<a href="#" class="clearfix">'
			+ '<img src="'+listMap[i]['imgUrl']+'" class="msg-photo" alt="'+listMap[i]['imgAlt']+'" />'
			+ '<span class="msg-body">'
			+ '<span class="msg-title">'
			+ '<span class="blue">'+listMap[i]['userName']+':</span>'
			+ listMap[i]['msgDetail']
			+ '</span>'
			+ '<span class="msg-time">'
			+ '<i class="ace-icon fa fa-clock-o"></i>'
			+ '<span>'+listMap[i]['msgTime']+'</span>'
			+ '</span>'
			+ '</span>'
			+ '</a>'
			+ '</li>';
	}
	$("#messageList").html(html);
}