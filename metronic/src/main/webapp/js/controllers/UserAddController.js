MetronicApp.controller('UserAddController', ['$scope', 'UserService', function($scope, UserService) {
    $scope.$on('$viewContentLoaded', function() {
    	});
    	
    $scope.submit = function() {
		//
		
		// submit
		Metronic.blockUI();
		UserService.save(null, $scope.user, function(){
			Metronic.unblockUI();
			Notification.success('注册成功');
		}, function(error){
			Metronic.unblockUI();
			Notification.error(error.data);
		});
	}
}]);
