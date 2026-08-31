import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DragoncrestTrinketEditor } from './dragoncrest-trinket-editor';

describe('DragoncrestTrinketEditor', () => {
  let component: DragoncrestTrinketEditor;
  let fixture: ComponentFixture<DragoncrestTrinketEditor>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DragoncrestTrinketEditor],
    }).compileComponents();

    fixture = TestBed.createComponent(DragoncrestTrinketEditor);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
