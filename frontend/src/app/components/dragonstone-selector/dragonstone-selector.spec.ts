import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DragonstoneSelector } from './dragonstone-selector';

describe('DragonstoneSelector', () => {
  let component: DragonstoneSelector;
  let fixture: ComponentFixture<DragonstoneSelector>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DragonstoneSelector],
    }).compileComponents();

    fixture = TestBed.createComponent(DragonstoneSelector);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
