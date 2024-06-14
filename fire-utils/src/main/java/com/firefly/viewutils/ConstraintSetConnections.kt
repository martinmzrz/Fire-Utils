package com.firefly.viewutils

import androidx.constraintlayout.widget.ConstraintSet

class ConstraintSetConnection(val constraintSet: ConstraintSet, val viewId: Int)

fun ConstraintSet.with(viewId: Int): ConstraintSetConnection {
    return ConstraintSetConnection(this, viewId)
}

fun ConstraintSetConnection.connectTopToParentTop(): ConstraintSetConnection {
    this.constraintSet.connect(
        this.viewId,
        ConstraintSet.TOP,
        ConstraintSet.PARENT_ID,
        ConstraintSet.TOP
    )
    return this
}

fun ConstraintSetConnection.connectBottomToViewTop(viewId: Int): ConstraintSetConnection {
    this.constraintSet.connect(
        this.viewId,
        ConstraintSet.BOTTOM,
        viewId,
        ConstraintSet.TOP
    )
    return this
}

fun ConstraintSetConnection.connectBottomToParentBottom(): ConstraintSetConnection {
    this.constraintSet.connect(
        this.viewId,
        ConstraintSet.BOTTOM,
        ConstraintSet.PARENT_ID,
        ConstraintSet.BOTTOM
    )
    return this
}

fun ConstraintSetConnection.connectTopToViewBottom(viewId: Int): ConstraintSetConnection {
    this.constraintSet.connect(this.viewId, ConstraintSet.TOP, viewId, ConstraintSet.BOTTOM)
    return this
}

fun ConstraintSetConnection.connectStartToParentStart(): ConstraintSetConnection {
    this.constraintSet.connect(
        this.viewId,
        ConstraintSet.START,
        ConstraintSet.PARENT_ID,
        ConstraintSet.START
    )
    return this
}

fun ConstraintSetConnection.connectStartToViewEnd(viewId: Int): ConstraintSetConnection {
    this.constraintSet.connect(
        this.viewId,
        ConstraintSet.START,
        viewId,
        ConstraintSet.END
    )

    return this
}

fun ConstraintSetConnection.connectStartToViewStart(viewId: Int): ConstraintSetConnection {
    this.constraintSet.connect(
        this.viewId,
        ConstraintSet.START,
        viewId,
        ConstraintSet.START
    )

    return this
}

fun ConstraintSetConnection.connectEndToViewEnd(viewId: Int): ConstraintSetConnection {
    this.constraintSet.connect(
        this.viewId,
        ConstraintSet.END,
        viewId,
        ConstraintSet.END
    )

    return this
}

fun ConstraintSetConnection.connectEndToViewStart(viewId: Int): ConstraintSetConnection {
    this.constraintSet.connect(
        this.viewId,
        ConstraintSet.END,
        viewId,
        ConstraintSet.START
    )
    return this
}

fun ConstraintSetConnection.connectEndToParentEnd(): ConstraintSetConnection {
    this.constraintSet.connect(
        this.viewId,
        ConstraintSet.END,
        ConstraintSet.PARENT_ID,
        ConstraintSet.END
    )
    return this
}

fun ConstraintSetConnection.clearEnd():ConstraintSetConnection {
    this.constraintSet.clear(this.viewId, ConstraintSet.END)
    return this
}

fun ConstraintSetConnection.clearStart():ConstraintSetConnection {
    this.constraintSet.clear(this.viewId, ConstraintSet.START)
    return this
}

fun ConstraintSetConnection.clearBottom():ConstraintSetConnection {
    this.constraintSet.clear(this.viewId, ConstraintSet.BOTTOM)
    return this
}

fun ConstraintSetConnection.clearTop():ConstraintSetConnection {
    this.constraintSet.clear(this.viewId, ConstraintSet.TOP)
    return this
}

fun ConstraintSetConnection.clearAll():ConstraintSetConnection {
    return this.clearTop().clearBottom().clearStart().clearEnd()
}

fun ConstraintSetConnection.connectHorizontallyToParent(): ConstraintSetConnection {
    return this.connectEndToParentEnd().connectStartToParentStart()
}

fun ConstraintSetConnection.connectVerticallyToParent(): ConstraintSetConnection {
    return this.connectBottomToParentBottom().connectTopToParentTop()
}

fun ConstraintSetConnection.setVisibility(visibility: Int): ConstraintSetConnection {
    this.constraintSet.setVisibility(this.viewId, visibility)
    return this
}

fun ConstraintSetConnection.applyAspectRatio(aspectRatio: String): ConstraintSetConnection {
    this.constraintSet.setDimensionRatio(this.viewId, aspectRatio)
    return this
}

fun ConstraintSetConnection.setHeight(height: Int): ConstraintSetConnection {
    this.constraintSet.constrainHeight(this.viewId, height)
    return this
}

fun ConstraintSetConnection.setWidth(width: Int): ConstraintSetConnection {
    this.constraintSet.constrainWidth(this.viewId, width)
    return this
}

fun ConstraintSetConnection.setSize(width: Int, height: Int): ConstraintSetConnection {
    return this.setHeight(height).setWidth(width)
}

fun ConstraintSetConnection.getConstraintSet(): ConstraintSet {
    return this.constraintSet
}