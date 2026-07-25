import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MasterySelector } from './mastery-selector';

describe('MasterySelector', () => {
  let component: MasterySelector;
  let fixture: ComponentFixture<MasterySelector>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MasterySelector],
    }).compileComponents();

    fixture = TestBed.createComponent(MasterySelector);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
