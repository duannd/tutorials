package com.duannd.patterns.creational.prototype;

import com.google.common.base.MoreObjects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class PrototypeUser implements Cloneable {

    private int id;
    private String name;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString() + "; hashcode: "+ hashCode();
    }

    @Override
    public PrototypeUser clone() throws CloneNotSupportedException {
        PrototypeUser user = (PrototypeUser) super.clone();
        user.id = this.id;
        user.name = this.name;
        return user;
    }
}
