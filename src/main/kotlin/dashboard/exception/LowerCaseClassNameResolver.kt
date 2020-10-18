package dashboard.exception

import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase

class LowerCaseClassNameResolver : TypeIdResolverBase() {

    override fun idFromValue(value: Any) = value.javaClass.simpleName.toLowerCase()

    override fun idFromValueAndType(value: Any, suggestedType: Class<*>?) = idFromValue(value)

    override fun getMechanism(): JsonTypeInfo.Id = JsonTypeInfo.Id.CUSTOM
}