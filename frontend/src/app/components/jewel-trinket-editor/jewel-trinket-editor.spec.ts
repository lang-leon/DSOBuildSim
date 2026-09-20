import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JewelTrinketEditor } from './jewel-trinket-editor';

describe('JewelTrinketEditor', () => {
  let component: JewelTrinketEditor;
  let fixture: ComponentFixture<JewelTrinketEditor>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [JewelTrinketEditor],
    }).compileComponents();

    fixture = TestBed.createComponent(JewelTrinketEditor);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
