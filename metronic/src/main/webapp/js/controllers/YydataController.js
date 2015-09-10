
MetronicApp.controller('YydataController', [ '$scope', 'YydataService',
		function($scope, YydataService) {
			console.log('YydataController');
			YydataService.findAll(null, null, function(data) {
				$scope.yydatas = data;
			}, function(error) {
				$scope.message = error;
			});

		} ]);
