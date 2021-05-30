// Verilated -*- C++ -*-
// DESCRIPTION: Verilator output: Tracing implementation internals
#include "verilated_vcd_c.h"
#include "VBBox__Syms.h"


//======================

void VBBox::trace (VerilatedVcdC* tfp, int, int) {
    tfp->spTrace()->addCallback (&VBBox::traceInit, &VBBox::traceFull, &VBBox::traceChg, this);
}
void VBBox::traceInit(VerilatedVcd* vcdp, void* userthis, uint32_t code) {
    // Callback from vcd->open()
    VBBox* t=(VBBox*)userthis;
    VBBox__Syms* __restrict vlSymsp = t->__VlSymsp; // Setup global symbol table
    if (!Verilated::calcUnusedSigs()) vl_fatal(__FILE__,__LINE__,__FILE__,"Turning on wave traces requires Verilated::traceEverOn(true) call before time 0.");
    vcdp->scopeEscape(' ');
    t->traceInitThis (vlSymsp, vcdp, code);
    vcdp->scopeEscape('.');
}
void VBBox::traceFull(VerilatedVcd* vcdp, void* userthis, uint32_t code) {
    // Callback from vcd->dump()
    VBBox* t=(VBBox*)userthis;
    VBBox__Syms* __restrict vlSymsp = t->__VlSymsp; // Setup global symbol table
    t->traceFullThis (vlSymsp, vcdp, code);
}

//======================


void VBBox::traceInitThis(VBBox__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    vcdp->module(vlSymsp->name()); // Setup signal names
    // Body
    {
	vlTOPp->traceInitThis__1(vlSymsp, vcdp, code);
    }
}

void VBBox::traceFullThis(VBBox__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vlTOPp->traceFullThis__1(vlSymsp, vcdp, code);
    }
    // Final
    vlTOPp->__Vm_traceActivity = 0U;
}

void VBBox::traceInitThis__1(VBBox__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vcdp->declBit  (c+1,"clock",-1);
	vcdp->declBit  (c+2,"reset",-1);
	vcdp->declBus  (c+3,"io_in1",-1,31,0);
	vcdp->declBus  (c+4,"io_in2",-1,31,0);
	vcdp->declBus  (c+5,"io_out",-1,31,0);
	vcdp->declBit  (c+1,"BBox clock",-1);
	vcdp->declBit  (c+2,"BBox reset",-1);
	vcdp->declBus  (c+3,"BBox io_in1",-1,31,0);
	vcdp->declBus  (c+4,"BBox io_in2",-1,31,0);
	vcdp->declBus  (c+5,"BBox io_out",-1,31,0);
	vcdp->declBus  (c+3,"BBox BBAdder_in1",-1,31,0);
	vcdp->declBus  (c+4,"BBox BBAdder_in2",-1,31,0);
	vcdp->declBus  (c+6,"BBox BBAdder_out",-1,31,0);
	vcdp->declQuad (c+7,"BBox BBAdder in1",-1,32,0);
	vcdp->declQuad (c+9,"BBox BBAdder in2",-1,32,0);
	vcdp->declQuad (c+11,"BBox BBAdder out",-1,33,0);
    }
}

void VBBox::traceFullThis__1(VBBox__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VBBox* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vcdp->fullBit  (c+1,(vlTOPp->clock));
	vcdp->fullBit  (c+2,(vlTOPp->reset));
	vcdp->fullBus  (c+3,(vlTOPp->io_in1),32);
	vcdp->fullBus  (c+4,(vlTOPp->io_in2),32);
	vcdp->fullBus  (c+5,(vlTOPp->io_out),32);
	vcdp->fullBus  (c+6,((vlTOPp->io_in1 + vlTOPp->io_in2)),32);
	vcdp->fullQuad (c+7,((QData)((IData)(vlTOPp->io_in1))),33);
	vcdp->fullQuad (c+9,((QData)((IData)(vlTOPp->io_in2))),33);
	vcdp->fullQuad (c+11,((VL_ULL(0x3ffffffff) 
			       & ((QData)((IData)(vlTOPp->io_in1)) 
				  + (QData)((IData)(vlTOPp->io_in2))))),34);
    }
}
