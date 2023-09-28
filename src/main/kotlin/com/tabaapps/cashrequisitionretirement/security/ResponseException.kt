package com.tabaapps.cashrequisitionretirement.security

import java.lang.RuntimeException

class ResponseException(override val message: String?) : RuntimeException() {
}