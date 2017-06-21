package com.poslovna.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.poslovna.model.users.access.Permission;

public interface Interceptable {

	public HashMap<String, ArrayList<Permission>> getMethodPermissions();
}
