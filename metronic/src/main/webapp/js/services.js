MetronicApp.service('UserService', [ '$resource', function($resource) {
	return $resource(Global.ROOT_PATH + '/rest/user/:id', null, {
		'save' : {
			method : 'POST',
			url : Global.ROOT_PATH + '/rest/user'
		},
		'update' : {
			method : 'PUT'
		},
		'updatePersonal' : {
			method : 'PUT',
			url : Global.ROOT_PATH + '/rest/user/:username/personal'
		},
		'changePassword' : {
			method : 'PUT',
			url : Global.ROOT_PATH + '/rest/user/:username/password'
		},
		'enable' : {
			method : 'PUT',
			url : Global.ROOT_PATH + '/rest/user/enable'
		},
		'disable' : {
			method : 'PUT',
			url : Global.ROOT_PATH + '/rest/user/disable'
		},
		'DELETE' : {
			method : 'DELETE'
		},
		'findAll' : {
			method : 'GET',
			url : Global.ROOT_PATH + '/rest/user',
			isArray : true
		}
	});
} ]);
