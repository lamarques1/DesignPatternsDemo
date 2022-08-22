package com.lamarques.exception

class DomainException(override val message: String?): RuntimeException(message) {
}